package com.batch.config;

import com.batch.modules.batch.repository.BatchRepository;
import com.batch.modules.batch.tasklet.BatchTasklet;
import com.batch.modules.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class JobConfig {

    private final OrderRepository orderRepository;
    private final BatchRepository batchRepository;

    private final JobBuilderFactory jobs;

    private final StepBuilderFactory steps;

    @Bean
    public Job job() {
        return jobs.get("job")
                .start(step())
                .build();
    }

    @Bean
    protected Step step() {
        return steps.get("step")
                .tasklet(new BatchTasklet(orderRepository,batchRepository))
                .build();
    }

}
