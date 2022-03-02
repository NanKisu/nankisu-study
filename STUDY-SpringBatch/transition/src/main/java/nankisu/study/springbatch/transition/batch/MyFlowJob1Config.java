package nankisu.study.springbatch.transition.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyFlowJob1Config {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob1() {
		return jobBuilderFactory.get("myFlowJob1")
				.start(myTaskletStep1())
				.on("FAILED")
				.to(myTaskletStep2())
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myTaskletStep1() {
		return stepBuilderFactory.get("myTaskletStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myTaskletStep1 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step myTaskletStep2() {
		return stepBuilderFactory.get("myTaskletStep2")
				.tasklet((contribution, context) -> {
					System.out.println("myTaskletStep2 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}

	@Bean
	public Step myTaskletStep3() {
		return stepBuilderFactory.get("myTaskletStep3")
				.tasklet((contribution, context) -> {
					System.out.println("myTaskletStep3 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
