package nankisu.study.springbatch.transition.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyFlowJob2Config {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob2() {
		return  this.jobBuilderFactory.get("job")
				.start(myStep1())
					.on("FAILED")
					.to(myStep2())
					.on("*")
					.end()
				.from(myStep1())
					.on("*")
					.to(myStep3())
					.next(myStep4())
					.on("*")
					.stopAndRestart(myStep5())
				.end()
//				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("mySte1 running");
//					throw new Exception();
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("mySte2 running");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	@Bean
	public Step myStep3() {
		return stepBuilderFactory.get("myStep3")
				.tasklet((contribution, context) -> {
					System.out.println("mySte3 running");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	@Bean
	public Step myStep4() {
		return stepBuilderFactory.get("myStep4")
				.tasklet((contribution, context) -> {
					System.out.println("mySte4 running");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
	@Bean
	public Step myStep5() {
		return stepBuilderFactory.get("myStep5")
				.tasklet((contribution, context) -> {
					System.out.println("mySte5 running");
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
