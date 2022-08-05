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
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MultiThreadStepJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final ItemReader<Integer> asyncItemReader;
	private final ItemProcessor<Integer, String> syncItemProcessor;
	private final ItemWriter<String> syncItemWriter;
	
	@Bean
	public Job multiThreadStepJob() {
		return jobBuilderFactory.get("multiThreadStepJob")
				.start(multiThreadStep())
				.incrementer(new RunIdIncrementer())
				.listener(new MyJobExcutionListener())
				.build();
	}
	
	@Bean
	public Step multiThreadStep() {
		return stepBuilderFactory.get("multiThreadStep")
				.<Integer, String>chunk(100)
				.reader(asyncItemReader)
				.processor(syncItemProcessor)
				.writer(syncItemWriter)
				.taskExecutor(new SimpleAsyncTaskExecutor())
				.build();
	}
}
