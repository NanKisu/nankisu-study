package nankisu.study.springbatch.asyncprocessorwriter.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AsyncJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job syncJob() {
		return jobBuilderFactory.get("syncJob")
				.start(syncStep())
				.incrementer(new RunIdIncrementer())
				.listener(new MyJobExcutionListener())
				.build();
	}
	
	@Bean
	public Step syncStep() {
		return stepBuilderFactory.get("syncStep")
				.<Integer, String>chunk(100)
				.reader(syncItemReader())
				.processor(syncItemProcessor())
				.writer(syncItemWriter())
				.build();
	}
	
	@Bean
	public Job asyncJob() {
		return jobBuilderFactory.get("asyncJob")
				.start(asyncStep())
				.incrementer(new RunIdIncrementer())
				.listener(new MyJobExcutionListener())
				.build();
	}
	
	@Bean
	public Step asyncStep() {
		return stepBuilderFactory.get("asyncStep")
				.<Integer, Future<String>>chunk(100)
				.reader(syncItemReader())
				.processor(asyncItemProcessor())
				.writer(asyncItemWriter())
				.build();
	}

	@Bean
	@JobScope
	public ItemReader<Integer> syncItemReader(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10000; i++) {
			list.add(i);
		}
		return new ListItemReader<Integer>(list);
	}
	
	@Bean
	public ItemProcessor<Integer, String> syncItemProcessor(){
		return new ItemProcessor<Integer, String>() {
			@Override
			public String process(Integer item) throws Exception {
				Thread.sleep(10);
				return item.toString();
			}
		};
	}
	
	@Bean
	public ItemWriter<String> syncItemWriter(){
		return new ItemWriter<String>() {
			@Override
			public void write(List<? extends String> items) throws Exception {
				System.out.println(items);
			}
		};
	}
	
	@Bean
	public ItemProcessor<Integer, Future<String>> asyncItemProcessor(){
		AsyncItemProcessor<Integer, String> asyncItemProcessor = new AsyncItemProcessor<Integer, String>();
		asyncItemProcessor.setDelegate(syncItemProcessor());
		asyncItemProcessor.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return asyncItemProcessor;
	}
	
	@Bean
	public ItemWriter<Future<String>> asyncItemWriter(){
		AsyncItemWriter<String> asyncItemWriter = new AsyncItemWriter<String>();
		asyncItemWriter.setDelegate(syncItemWriter());
		return asyncItemWriter;
	}
}
