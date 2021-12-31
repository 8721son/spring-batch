package com.batch.modules.batch.tasklet;

import com.batch.modules.batch.domain.entity.BatchEntity;
import com.batch.modules.batch.repository.BatchRepository;
import com.batch.modules.order.repository.OrderRepository;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BatchTasklet implements Tasklet, StepExecutionListener {

    private final OrderRepository orderRepository;
    private final BatchRepository batchRepository;

    List<String> storeList = new ArrayList<>();
    List<String> productList = new ArrayList<>();

    public BatchTasklet(OrderRepository orderRepository,BatchRepository batchRepository){
        this.orderRepository=orderRepository;
        this.batchRepository=batchRepository;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        storeList=orderRepository.findDistinctStore();
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        for (String s: storeList
             ) {
            productList=orderRepository.findDistinctNameByStore(s);
            for (String p: productList
                 ) {
                Optional<BatchEntity> optional = batchRepository.findByStoreAndName(s, p);
                long totalPrice = orderRepository.getTotalPrice(s,p);
                long totalCount = orderRepository.getTotalCount(s,p);
                if(optional.isPresent()){
                    BatchEntity entity = optional.get();
                    entity.setTotalPrice(totalPrice);
                    entity.setTotalCount(totalCount);
                }else{
                    batchRepository.save(BatchEntity.builder()
                            .store(s)
                            .name(p)
                            .totalPrice(totalPrice)
                            .totalCount(totalCount)
                            .build());
                }
            }
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
