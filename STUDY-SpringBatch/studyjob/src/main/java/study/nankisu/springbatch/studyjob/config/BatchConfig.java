package study.nankisu.springbatch.studyjob.config;

import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job job() {
		return jobBuilderFactory.get("job")
				.start(step1())
				.next(step2())
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("step1");
					JobParameters jobParameters = contribution.getStepExecution().getJobExecution().getJobParameters();
					System.out.println(jobParameters);
					System.out.println(jobParameters.getDate("runDate").hashCode());
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	
	@Bean
	public Step step2() {
		return stepBuilderFactory.get("step2")
				.tasklet((contribution, chunkContext) -> {
					System.out.println("step2");
					Map jobParameters = chunkContext.getStepContext().getJobParameters();
					System.out.println(jobParameters);
					System.out.println(jobParameters.get("runDate").hashCode());
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
