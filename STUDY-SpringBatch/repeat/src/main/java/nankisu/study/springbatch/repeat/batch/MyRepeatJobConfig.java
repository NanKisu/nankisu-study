package nankisu.study.springbatch.repeat.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.item.SimpleRetryExceptionHandler;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.exception.CompositeExceptionHandler;
import org.springframework.batch.repeat.exception.DefaultExceptionHandler;
import org.springframework.batch.repeat.exception.ExceptionHandler;
import org.springframework.batch.repeat.exception.LogOrRethrowExceptionHandler;
import org.springframework.batch.repeat.exception.RethrowOnThresholdExceptionHandler;
import org.springframework.batch.repeat.exception.SimpleLimitExceptionHandler;
import org.springframework.batch.repeat.policy.CompositeCompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.repeat.policy.TimeoutTerminationPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyRepeatJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myRepeatJob() {
		return jobBuilderFactory.get("myRepeatJob")
				.start(myRepeatStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myRepeatStep() {
		return stepBuilderFactory.get("myRepeatStep")
				.<String, String>chunk(myCompletionPolicy())
				.reader(new ListItemReader<String>(List.of("str1", "str2", "str3", "str4", "str5")))
//				.reader(new ItemReader<String>() {
//					@Override
//					public String read()
//							throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//						return "str";
//					}
//				})
				.processor(new ItemProcessor<String, String>() {
					@Override
					public String process(String str) throws Exception {
						return str;
					}
				})
				.writer((strs) -> {
					System.out.println(strs);
					throw new Exception();
				})
				.exceptionHandler(myExceptionHandler())
				.build();
	}
	
	@Bean
	public CompletionPolicy myCompletionPolicy() {
		CompositeCompletionPolicy completionPolicy = new CompositeCompletionPolicy();
		CompletionPolicy[] completionPolicies = {
			new SimpleCompletionPolicy(1),
			new TimeoutTerminationPolicy(100)
		};
		completionPolicy.setPolicies(completionPolicies);
		return completionPolicy;
	}
	
	@Bean
	public ExceptionHandler myExceptionHandler() {
		return new SimpleLimitExceptionHandler(3);
	}
}
