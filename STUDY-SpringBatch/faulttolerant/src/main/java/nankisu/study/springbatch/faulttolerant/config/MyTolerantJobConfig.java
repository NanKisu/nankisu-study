package nankisu.study.springbatch.faulttolerant.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyTolerantJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myTolerantJob() {
		return jobBuilderFactory.get("myTolerantJob")
				.start(myTolerantStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myTolerantStep() {
		return stepBuilderFactory.get("myTolerantStep")
				.<String, String>chunk(5)
				.reader(new ItemReader<String>() {
					int i = 0;
					
					@Override
					public String read()
							throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
						// TODO Auto-generated method stub
						i++;
						if(i == 4) {
							throw new IllegalArgumentException("throw exception");
						}
						return i > 10 ? null : "item" + i;
					}
				})
				.processor(new ItemProcessor<String, String>() {
					boolean flag = true;
					
					@Override
					public String process(String item) throws Exception {
						// TODO Auto-generated method stub
						if(item.equals("item5") && flag) {
							flag = false;
							throw new IllegalStateException("throw exception");
						}
						return item;
					}
				})
				.writer(new ItemWriter<String>() {

					@Override
					public void write(List<? extends String> items) throws Exception {
						// TODO Auto-generated method stub
						System.out.println(items);
					}
				})
				.faultTolerant()
				.skip(IllegalArgumentException.class)
				.skipLimit(5)
//				.skip(IllegalStateException.class)
//				.skipLimit(5)
				.retry(IllegalStateException.class)
				.retryLimit(5)
				.build();
	}
}
