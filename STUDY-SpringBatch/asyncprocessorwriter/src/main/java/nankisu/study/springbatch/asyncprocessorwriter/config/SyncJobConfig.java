package nankisu.study.springbatch.asyncprocessorwriter.config;

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
public class SyncJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final ItemReader<Integer> syncItemReader;
	private final ItemProcessor<Integer, String> syncItemProcessor;
	private final ItemWriter<String> syncItemWriter;
	
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
				.reader(syncItemReader)
				.processor(syncItemProcessor)
				.writer(syncItemWriter)
				.build();
	}
}
