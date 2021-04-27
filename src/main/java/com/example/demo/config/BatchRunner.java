package com.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableScheduling
public class BatchRunner implements CommandLineRunner {
    private final JobLauncher jobLauncher;
    private final Job job;

    /**
     * "초 분 시 일 월 요일"
     * 매 1분마다 실행 * /1 * * * *
     * @throws Exception
     */
    @Scheduled(cron = "1 * * * * ?")
    public void execute() throws Exception{
        JobParameters params = new JobParametersBuilder()
                .addString("jobId", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job,params);

    }
    @Override
    public void run(String... args) throws Exception {
        execute();
    }
}
