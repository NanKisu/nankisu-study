package study.nankisu.springbatch.springbatchhelloworld.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Configuration
public class HelloWorldBatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job helloWorldJob() {
		return jobBuilderFactory.get("helloWorldJob")
				.start(helloWorldStep())
				.build();				
	}
	
	@Bean
	public Step helloWorldStep() {
		return stepBuilderFactory.get("helloWorldStep")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("Hello World Batch");
					return RepeatStatus.FINISHED;
				})
				.build();				
	}
}
