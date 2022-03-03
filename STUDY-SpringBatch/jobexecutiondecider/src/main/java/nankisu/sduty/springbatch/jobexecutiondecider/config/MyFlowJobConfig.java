package nankisu.sduty.springbatch.jobexecutiondecider.config;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.sduty.springbatch.jobexecutiondecider.decider.MyJobExecutionDecider;

@Configuration
@RequiredArgsConstructor
public class MyFlowJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob() {
		return jobBuilderFactory.get("myFlowJob")
				.start(myStep())
				.next(jobExecutionDecider())
				.from(jobExecutionDecider())
					.on("OVER5")
					.to(over5Step())
				.from(jobExecutionDecider())
					.on("UNDER5")
					.to(under5Step())
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public JobExecutionDecider jobExecutionDecider() {
		return new MyJobExecutionDecider();
	}
	
	@Bean
	public Step myStep() {
		return stepBuilderFactory.get("myStep")
				.tasklet((contribution, context) -> {
					System.out.println("myStep running...");
					int ran = new Random(System.currentTimeMillis()).nextInt(10);
					System.out.println("ran: " + ran);
					contribution.getStepExecution().getJobExecution().getExecutionContext().put("ran", ran);
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step over5Step() {
		return stepBuilderFactory.get("over5Step")
				.tasklet((contribution, context) -> {
					System.out.println("over5Step running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step under5Step() {
		return stepBuilderFactory.get("under5Step")
				.tasklet((contribution, context) -> {
					System.out.println("under5Step running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
