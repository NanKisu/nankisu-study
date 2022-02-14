package nankisu.study.springbatch.batchproperties.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.batchproperties.BatchpropertiesApplication;

@Configuration
@RequiredArgsConstructor
public class MyBatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myJob1() {
		return jobBuilderFactory.get("myJob1")
				.start(myStep1())
				.build();
	}
	
	@Bean
	public Job myJob2() {
		return jobBuilderFactory.get("myJob2")
				.start(myStep2())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("running myStep1...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("running myStep2...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
