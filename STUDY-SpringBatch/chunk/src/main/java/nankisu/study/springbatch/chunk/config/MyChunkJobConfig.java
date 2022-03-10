package nankisu.study.springbatch.chunk.config;

import java.util.Arrays;
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
public class MyChunkJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myChunkJob() {
		return jobBuilderFactory.get("myChunkJob")
				.start(myChunkStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myChunkStep() {
		return stepBuilderFactory.get("myChunkStep")
				.<String, String>chunk(5)
				.reader(new ListItemReader<String>(Arrays.asList("item1", "item2", "item3", "item4", "item5", "item6")))
				.processor(new ItemProcessor<String, String>() {
					@Override
					public String process(String item) throws Exception {
						System.out.println("processing " + item + "...");
						return "my" + item;
					}
				})
				.writer(new ItemWriter<String>() {
					@Override
					public void write(List<? extends String> items) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("wtire " + items);
					}
				})
				.build();
	}
}
