package nankisu.study.springbatch.simpleflow.batch;

import java.util.Random;

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
public class MyFlowJob1Config {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob1() {
		return jobBuilderFactory.get("myFlowJob1")
				.start(myFlow1())
				.next(myStep4())
				.end()
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Flow myFlow1() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myFlow1");
		return flowBuilder
				.start(myStep1())
					.on(ExitStatus.COMPLETED.getExitCode())
					.to(myStep2())
				.from(myStep1())
					.on(ExitStatus.FAILED.getExitCode())
					.to(myStep3())
				.end();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myStep1 running...");
					Integer ran = new Random(System.currentTimeMillis()).nextInt();
					System.out.println(ran);
					if(ran%2 == 1) {
						throw new Exception("Odd Exception!");
					}
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
	
	@Bean
	public Step myStep4() {
		return stepBuilderFactory.get("myStep4")
				.tasklet((contribution, context) -> {
					System.out.println("myStep4 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
		
	}
}
