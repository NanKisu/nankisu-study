package nankisu.study.springbatch.simplejob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final Step myStep1;
	private final Step myStep2;
	
	@Bean
	public Job myJob1() {
		return jobBuilderFactory.get("myJob1")
				.start(myStep1)
				.next(myStep2)
				.build();
	}
}
