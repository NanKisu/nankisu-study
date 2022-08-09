package nankisu.study.springbatch.eventlistener.batch.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.eventlistener.batch.listener.MyJobListener;
import nankisu.study.springbatch.eventlistener.batch.listener.MyProcessorListener;
import nankisu.study.springbatch.eventlistener.batch.listener.MyReaderListener;
import nankisu.study.springbatch.eventlistener.batch.listener.MyStepListener;
import nankisu.study.springbatch.eventlistener.batch.listener.MyWriterListener;

@Configuration
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep())
				.listener(new MyJobListener())
				.build();
	}
	
	@Bean
	public Step myStep() {
		return stepBuilderFactory.get("myStep")
				.<Integer, String>chunk(100)
				.reader(myItemReader())
				.processor(myItemProcessor())
				.writer(myItemWriter())
				.faultTolerant()
				.skip(Exception.class)
				.skipLimit(10)
				.retry(Exception.class)
				.retryLimit(10)
				.listener(new MySkipListener())
				.listener(new MyRetryListener())
				.listener(new MyReaderListener())
				.listener(new MyProcessorListener())
				.listener(new MyWriterListener())
				.listener(new MyChunkListener())
				.listener(new MyStepListener())
				.build();
	}
	
	@Bean
	public ItemReader<Integer> myItemReader() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10000; i++) {
			list.add(i);
		}
		return new ListItemReader<Integer>(list);
	}
	
	@Bean
	public ItemProcessor<Integer, String> myItemProcessor(){
		return new ItemProcessor<Integer, String>() {
			@Override
			public String process(Integer item) throws Exception {
				if(item % 10 == 0)
					throw new Exception();
				return item.toString();
			}
		};
	}
	
	@Bean
	public ItemWriter<String> myItemWriter(){
		return new ItemWriter<String>() {
			@Override
			public void write(List<? extends String> items) throws Exception {
				System.out.println(items);
			}
		};
	}
}
