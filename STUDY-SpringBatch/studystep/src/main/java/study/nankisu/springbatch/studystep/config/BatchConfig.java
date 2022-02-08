package study.nankisu.springbatch.studystep.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import study.nankisu.springbatch.studystep.tasklet.MyTasklet;

@Configuration
@AllArgsConstructor
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep1())
				.next(myStep2())
				.next(myStep3())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myStep1");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	
	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("myStep3");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step myStep3() {
		return stepBuilderFactory.get("myStep3")
				.tasklet(new MyTasklet())
				.build();
	}
}
