package nankisu.sduty.springbatch.exitstatus.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.sduty.springbatch.exitstatus.listener.MyStepExecutionListener;

@Configuration
@RequiredArgsConstructor
public class MyFlowJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob() {
		return jobBuilderFactory.get("myFlowJob")
				.start(myStep1())
					.on("MY STATUS1")
					.to(myStep2())
						.on("MY STATUS2")
						.to(myStep3())
				.end()
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myStep1 running...");
					contribution.setExitStatus(new ExitStatus("MY STATUS1"));
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("myStep2 running...");
					return RepeatStatus.FINISHED;
				})
				.listener(new MyStepExecutionListener())
				.build();
	}
	
	@Bean
	public Step myStep3() {
		return stepBuilderFactory.get("myStep3")
				.tasklet((contribution, context) -> {
					System.out.println("myStep3 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
