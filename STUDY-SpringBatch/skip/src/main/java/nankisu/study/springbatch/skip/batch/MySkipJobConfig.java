package nankisu.study.springbatch.skip.batch;

import java.util.Iterator;
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
import nankisu.study.springbatch.skip.exception.MyException01;

@Configuration
@RequiredArgsConstructor
public class MySkipJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job mySkipJob() {
		return jobBuilderFactory.get("mySkipJob")
				.start(mySkipStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step mySkipStep() {
		return stepBuilderFactory.get("mySkipStep")
				.<String, String>chunk(5)
				.reader(new ItemReader<String>() {
					int i = 0;
					@Override
					public String read()
							throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
						i++;
						if(i > 10) {
							return null;
						}
						if(i == 2) {
							throw new MyException01();
						}
						return "item" + i;
					}
				})
				.processor(new ItemProcessor<String, String>() {
					@Override
					public String process(String item) throws Exception {
						if(item.equals("item4")) {
							throw new MyException01();
						}
						return item;
					}
				})
				.writer(new ItemWriter<String>() {
					@Override
					public void write(List<? extends String> items) throws Exception {
						System.out.println(items.size());
						for (String item : items) {
							if(item.equals("item6")
									|| item.equals("item8")) {
								throw new MyException01();
							}
							System.out.println(item);
						}
					}
				})
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(3)
				.noSkip(MyException01.class)				
				.build();
	}
}
