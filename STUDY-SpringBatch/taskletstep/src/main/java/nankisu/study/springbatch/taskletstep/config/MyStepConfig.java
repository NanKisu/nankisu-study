package nankisu.study.springbatch.taskletstep.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MyStepConfig {
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step myTaskletStep() {
		return stepBuilderFactory.get("myTaskletStep")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myTaskletStep running...");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	
	@Bean
	public Step myChunkTaskletStep() {
		return stepBuilderFactory.get("myChunkTaskletStep")
				.<String, String>chunk(3)
				.reader(new ListItemReader<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")))
				.processor(new ItemProcessor<String, String>() {

					@Override
					public String process(String item) throws Exception {
						// TODO Auto-generated method stub
						return new StringBuffer("processed ").append(item).toString();
					}
				})
				.writer(new ItemWriter<String>() {

					@Override
					public void write(List<? extends String> items) throws Exception {
						// TODO Auto-generated method stub
						System.out.println(items);
					}
				})
				.build();
				
	}
}
