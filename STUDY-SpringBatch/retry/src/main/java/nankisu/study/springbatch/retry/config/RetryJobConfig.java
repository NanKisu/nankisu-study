package nankisu.study.springbatch.retry.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
					@Override
					public String process(Integer item) throws Exception {
						// TODO Auto-generated method stub
						System.out.println(item);
//						if(item == 2) {
//							throw new Exception();
//						}
						return item.toString();
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
				.build();
	}
}
