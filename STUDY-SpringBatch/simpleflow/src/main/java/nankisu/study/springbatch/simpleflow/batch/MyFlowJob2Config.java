package nankisu.study.springbatch.simpleflow.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyFlowJob2Config {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob2() {
		return jobBuilderFactory.get("myFlowJob2")
				.start(myTryFlow())
				.next(myFinallyStep())
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Flow myTryFlow() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myTryFlow");
		return flowBuilder
				.start(myFirstStep())
					.on(ExitStatus.FAILED.getExitCode())
					.to(myAfterThrowStep())
				.from(myFirstStep())
					.on("*")
					.end()
				.end();
	}
	
	@Bean
	public Step myFirstStep() {
		return stepBuilderFactory.get("myFirstStep")
				.tasklet((contribution, context) -> {
					System.out.println("myFirstStep running...");
//					throw new Exception("FAIL");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myAfterThrowStep() {
		return stepBuilderFactory.get("myAfterThrowStep")
				.tasklet((contribution, context) -> {
					System.out.println("myAfterThrowStep running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myFinallyStep() {
		return stepBuilderFactory.get("myFinallyStep")
				.tasklet((contribution, context) -> {
					System.out.println("myFinallyStep running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
