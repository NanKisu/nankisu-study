package nankisu.study.springbatch.simplejob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.simplejob.vaildator.MyJobValidator;

@Component
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final Step myStep1;
	private final Step myStep2;
	
	@Bean
	public Job myJob1() {
		return jobBuilderFactory.get("myJob1")
				.start(myStep1)
				.next(myStep2)
				.incrementer(new MyJobParameterIncrementer())
				//.incrementer(new RunIdIncrementer())
				.validator(new MyJobValidator())
				//.validator(new DefaultJobParametersValidator(new String[]{"name"}, new String[]{"age"}))
				.preventRestart()
				.build();
	}
}
