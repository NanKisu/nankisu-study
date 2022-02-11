package nankisu.study.springbatch.jobrepogitory.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.jobrepogitory.listener.MyJobListener;

@Configuration
@RequiredArgsConstructor
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final MyJobListener myJobListener;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.listener(myJobListener)
				.start(myStep1())
				.next(myStep2())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
			.tasklet((contribution, context) -> {
				System.out.println("myStep1 running");
				return RepeatStatus.FINISHED;
			})
			.build();
	}

	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("myStep2 running");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
