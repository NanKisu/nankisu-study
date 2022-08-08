package nankisu.study.springbatch.asyncprocessorwriter.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ParallelStepsJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job parallelStepsJob() {
		return jobBuilderFactory.get("parallelStepsJob")
				.start(flowA())
				.split(new SimpleAsyncTaskExecutor()).add(flowB())
				.end()
				.build();
	}
	
	@Bean
	public Flow flowA() {
		return new FlowBuilder<Flow>("flowA")
				.start(stepA1())
				.next(stepA2())
				.next(stepA3())
				.build();
	}
	
	@Bean
	public Flow flowB() {
		return new FlowBuilder<Flow>("flowB")
				.start(stepB())
				.build();
	}
	
	@Bean
	public Step stepA1() {
		return stepBuilderFactory.get("stepA1")
				.tasklet((contribution, context) -> {
					System.out.println("stepA1");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step stepA2() {
		return stepBuilderFactory.get("stepA2")
				.tasklet((contribution, context) -> {
					System.out.println("stepA2");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step stepA3() {
		return stepBuilderFactory.get("stepA3")
				.tasklet((contribution, context) -> {
					System.out.println("stepA3");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step stepB() {
		return stepBuilderFactory.get("stepB")
				.tasklet((contribution, context) -> {
					System.out.println("stepB");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
