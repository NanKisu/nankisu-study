package nankisu.study.springbatch.operator.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep1())
				.next(myStep2())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myStep1 start");
					Thread.sleep(10000);
					System.out.println("myStep1 end");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("myStep2 start");
					Thread.sleep(10000);
					System.out.println("myStep2 end");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
