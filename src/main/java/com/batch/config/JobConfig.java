package com.batch.config;

import com.batch.modules.batch.entity.BatchEntity;
import com.batch.modules.order.dto.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class JobConfig {

    private final JobBuilderFactory jobs;

    private final StepBuilderFactory steps;

    @Bean
    public Job job() {
        return jobs.get("job").start(step()).build();
    }

    @Bean
    protected Step step() {
        return steps.get("step").<OrderEntity, BatchEntity> chunk(1).reader(reader()).writer(writer()).build();
    }

    @Bean
    protected ItemReader<OrderEntity> reader() {
        return null;
    }

    @Bean
    protected ItemWriter<BatchEntity> writer() {
        return null;
    }


}
