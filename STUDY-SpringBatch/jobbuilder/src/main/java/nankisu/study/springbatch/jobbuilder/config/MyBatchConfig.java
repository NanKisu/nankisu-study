package nankisu.study.springbatch.jobbuilder.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyBatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public Job myJob1() {
		return jobBuilderFactory.get("myJob1")
				.start(myStep1())
				.next(myStep2())
				.build();
	}
	
	@Bean
	public Job myJob2() {
		return jobBuilderFactory.get("myJob2")
				.start(myFlow1())
				.end()
				.build();
	}
	
	@Bean
	public Flow myFlow1() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myFlow1");
		return flowBuilder.start(myStep1())
				.next(myStep2())
				.end();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myStep1 running...");
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
