package nankisu.study.springbatch.StepBuilderFactory.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final Step myTaskletStep;
	private final Step mySimpleStep1;
	private final Step mySimpleStep2;
	private final Step myPartitionStep1;
	private final Step myPartitionStep2;
	private final Step myJobStep;
	private final Step myFlowStep;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myTaskletStep)
//				.next(mySimpleStep1)
//				.next(mySimpleStep2)
//				.next(myPartitionStep1)
//				.next(myPartitionStep2)
//				.next(myJobStep)
//				.next(myFlowStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}
}
