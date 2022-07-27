package nankisu.study.springbatch.retry.config;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.support.RepeatTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RetryJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job retryJob() {
		return jobBuilderFactory.get("retryJob")
				.start(retryStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step retryStep() {
		return stepBuilderFactory.get("retryStep")
				.<Integer, String>chunk(5)
				.reader(new ListItemReader<Integer>(List.of(1,2,3,4,5,6,7,8,9,10)))
				.processor(new ItemProcessor<Integer, String>() {
					private RetryTemplate retryTemplate;
					
					@Override
					public String process(Integer item) throws Exception {
//						if(item == 2) {
//							throw new Exception();
//						}
						retryTemplate = new RetryTemplate();
						SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(2, Map.of(Exception.class, true));
						retryTemplate.setRetryPolicy(simpleRetryPolicy);
						
						String result = retryTemplate.execute(
							new RetryCallback<String, Exception>() {
								@Override
								public String doWithRetry(RetryContext context) throws Exception {
									System.out.println(item);
									if(item == 2) {
										System.out.println("throw");
										throw new Exception();
									}
									return item.toString();
								}
							},
							new RecoveryCallback<String>() {

								@Override
								public String recover(RetryContext context) throws Exception {
									// TODO Auto-generated method stub
									return "0";
								}
							}
						);
						return result;
					}
				})
				.writer(new ItemWriter<String>() {
					@Override
					public void write(List<? extends String> items) throws Exception {
						// TODO Auto-generated method stub
						System.out.println(items);
						if(items.contains("2")) {
							throw new Exception();
						}
					}
				})
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(2)
				.retry(Exception.class)
				.retryLimit(2)
				.backOffPolicy(backOffPolicy())
				.build();
	}
	
	@Bean
	public BackOffPolicy backOffPolicy() {
		FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
		fixedBackOffPolicy.setBackOffPeriod(10000);
		return fixedBackOffPolicy;
	}
}
