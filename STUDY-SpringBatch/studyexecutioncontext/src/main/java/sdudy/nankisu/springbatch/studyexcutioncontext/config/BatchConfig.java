package sdudy.nankisu.springbatch.studyexecutioncontext.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import sdudy.nankisu.springbatch.studyexecutioncontext.tasklet.MyTasklet1;
import sdudy.nankisu.springbatch.studyexecutioncontext.tasklet.MyTasklet2;
import sdudy.nankisu.springbatch.studyexecutioncontext.tasklet.MyTasklet3;
import sdudy.nankisu.springbatch.studyexecutioncontext.tasklet.MyTasklet4;

@Configuration
@AllArgsConstructor
public class BatchConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final MyTasklet1 myTasklet1;
	private final MyTasklet2 myTasklet2;
	private final MyTasklet3 myTasklet3;
	private final MyTasklet4 myTasklet4;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep1())
				.next(myStep2())
				.next(myStep3())
				.next(myStep4())
				.build();				
	}
	
	@Bean
	public Step myStep1() {
		return stepBuilderFactory.get("myStep1")
				.tasklet(myTasklet1)
				.build();
	}
	
	@Bean
	public Step myStep2() {
		return stepBuilderFactory.get("myStep2")
				.tasklet(myTasklet2)
				.build();
	}
	
	@Bean
	public Step myStep3() {
		return stepBuilderFactory.get("myStep3")
				.tasklet(myTasklet3)
				.build();
	}
	
	@Bean
	public Step myStep4() {
		return stepBuilderFactory.get("myStep4")
				.tasklet(myTasklet4)
				.build();
	}
}
