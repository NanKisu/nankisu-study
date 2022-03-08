package nankisu.study.springbatch.jobscopestepscope.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
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
	private final MyTasklet1 myTasklet1;
	
	@Bean
	public Job myJob1() {
		return jobBuilderFactory.get("myJob1")
				.start(myStep1())
				.next(myStep1())
				.next(myStep2(null, null))
				.next(myStep2(null, null))
				.incrementer(new RunIdIncrementer())
				.build();
	}

	@Bean
	public Job myJob2() {
		return jobBuilderFactory.get("myJob2")
				.start(myStep1())
				.next(myStep1())
				.next(myStep2(null, null))
				.next(myStep2(null, null))
				.incrementer(new RunIdIncrementer())
				.listener(new MyJobExecutionListener())
				.build();
	}

	@Bean
	public Job myJob3() {
		return jobBuilderFactory.get("myJob3")
				.start(myStep3())
				.next(myStep4())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myStep1() {
		Step myStep1 = stepBuilderFactory.get("myStep1")
				.tasklet((contribution, context) -> {
					System.out.println("myStep1 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
		System.out.println("myStep1 called");		
		System.out.println(myStep1.hashCode());		
		return myStep1;
	}
	
	@Bean
	@JobScope
	public Step myStep2(@Value("#{jobParameters['run.id']}") Integer runId
				,@Value("#{jobExecutionContext[name]}") String name) {
		System.out.println("runId: " + runId);
		System.out.println("name: " + name);
		Step myStep2 = stepBuilderFactory.get("myStep2")
				.tasklet((contribution, context) -> {
					System.out.println("myStep2 running...");
					return RepeatStatus.FINISHED;
				})
				.build();
		System.out.println("myStep2 called");		
		System.out.println(myStep2.hashCode());		
		return myStep2;
	}
	
	@Bean
	public Step myStep3() {
		Step myStep3 = stepBuilderFactory.get("myStep3")
				.tasklet(myTasklet1)
				.listener(new MyStepExecutionListener())
				.build();
		System.out.println("myStep3 called");		
		System.out.println(myStep3.hashCode());		
		return myStep3;
	}

	@Bean
	public Step myStep4() {
		Step myStep4 = stepBuilderFactory.get("myStep4")
				.tasklet(myTasklet1)
				.build();
		System.out.println("myStep4 called");		
		System.out.println(myStep4.hashCode());		
		return myStep4;
	}
}
