package nankisu.study.springbatch.flowstep.batch;

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
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myTryCatchFinallyJob() {
		return jobBuilderFactory.get("myTryCatchFinallyJob")
				.start(myTryCatchFlowStep())
				.next(myFinallyStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myTryCatchFlowStep() {
		return stepBuilderFactory.get("myTryCatchFlowStep")
				.flow(myTryCatchFlow())
				.build();
	}
	
	@Bean
	public Flow myTryCatchFlow() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myTryCatchFlow");
		return flowBuilder
				.start(myFirstStep())
					.on(ExitStatus.FAILED.getExitCode())
					.to(myCatchStep())
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
					throw new Exception("FAIL");
//					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myCatchStep() {
		return stepBuilderFactory.get("myCatchStep")
				.tasklet((contribution, context) -> {
					System.out.println("myCatchStep running...");
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
