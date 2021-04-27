package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchJobConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job sampleJob(){
        return jobBuilderFactory.get("myjob")
                                .start(step1())
                                .next(step2())
                                .build();
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("tutorialStep1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("11111111");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
    @Bean
    public Step step2(){
        return stepBuilderFactory.get("tutorialStep2")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("2222222");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }



}
