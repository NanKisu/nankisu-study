package nankisu.study.springbatch.taskletstep.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final Step myTaskletStep;
	private final Step myChunkTaskletStep;
	private final Step myStep1;
	private final Step myStep2;
	
//	@Bean
//	public Job myJob() {
//		return jobBuilderFactory.get("myJob")
//				.start(myTaskletStep)
//				.next(myChunkTaskletStep)
//				.incrementer(new RunIdIncrementer())
//				.build();
//	}

	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep1)
				.next(myStep2)
				.build();
	}
}
