package nankisu.study.springbatch.asyncprocessorwriter.config;

import java.util.concurrent.Future;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AsyncJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final ItemReader<Integer> syncItemReader;
	private final ItemProcessor<Integer, Future<String>> asyncItemProcessor;
	private final ItemWriter<Future<String>> asyncItemWriter;
	
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
				.reader(syncItemReader)
				.processor(asyncItemProcessor)
				.writer(asyncItemWriter)
				.build();
	}
}
