package nankisu.study.springbatch.StepBuilderFactory.config;

import java.util.Collections;
import java.util.function.Function;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyStepConfig {
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step myTaskletStep() {
		return stepBuilderFactory.get("myTaskletStep")
				.tasklet((contribution, context) -> {
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step mySimpleStep1() {
		return stepBuilderFactory.get("mySimpleStep1")
				.<Integer, Integer>chunk(10)
				.reader(() -> {
					return null;
				})
				.processor((Function<Integer, Integer>)(item) -> {
					return item;
				})
				.writer((item) -> {
					System.out.println("item: " + item);
				})
				.build();
	}

	@Bean
	public Step mySimpleStep2() {
		return stepBuilderFactory.get("mySimpleStep2")
				.<Integer, Integer>chunk(new CompletionPolicy() {

					@Override
					public boolean isComplete(RepeatContext context, RepeatStatus result) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public boolean isComplete(RepeatContext context) {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public RepeatContext start(RepeatContext parent) {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public void update(RepeatContext context) {
						// TODO Auto-generated method stub
						
					}
					
				})
				.reader(() -> {
					return null;
				})
				.processor((Function<Integer, Integer>)(item) -> {
					return item;
				})
				.writer((item) -> {
					System.out.println("item: " + item);
				})
				.build();
	}
	
	@Bean
	public Step myPartitionStep1() {
		return stepBuilderFactory.get("myPartitionStep1")
				.partitioner(myTaskletStep())
				.build();
	}
	
	@Bean
	public Step myPartitionStep2() {
		return stepBuilderFactory.get("myPartitionStep2")
				.partitioner("myTaskletStep", null)
				.build();
	}
	
	@Bean
	public Step myJobStep() {
		return stepBuilderFactory.get("myJobStep")
				.job(null)
				.build();
	}
	
	@Bean
	public Step myFlowStep() {
		return stepBuilderFactory.get("myFlowStep")
				.flow(null)
				.build();
	}
}
