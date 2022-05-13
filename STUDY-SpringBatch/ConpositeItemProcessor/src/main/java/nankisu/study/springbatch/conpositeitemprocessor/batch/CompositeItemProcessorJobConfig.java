package nankisu.study.springbatch.conpositeitemprocessor.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.support.builder.CompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CompositeItemProcessorJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myStringJob() {
		return jobBuilderFactory.get("myStringJob")
				.start(myStringStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myStringStep() {
		return stepBuilderFactory.get("myStringStep")
				.<String,String>chunk(5)
				.reader(new ListItemReader<String>(List.of("Nankisu", "Nankisu", "Nankisu", "Nankisu", "Nankisu", "Nankisu")))
				.processor(myCompositeItemProcessor())
				.writer((item) -> {
					System.out.println(item);
				})
				.build();
	}
	
	@Bean
	public ItemProcessor<String, String> myCompositeItemProcessor(){
		List<ItemProcessor<String, String>> itemProcessorList = new ArrayList<ItemProcessor<String,String>>();
		itemProcessorList.add(toRowwerCaseItemProcessor());
		itemProcessorList.add(addCountIdItemProcessor());
		return new CompositeItemProcessorBuilder<String, String>()
				.delegates(itemProcessorList)
				.build();
	}
	
	@Bean
	public ItemProcessor<String, String> addCountIdItemProcessor(){
		return new ItemProcessor<String, String>() {
			int count = 0;
			
			@Override
			public String process(String item) throws Exception {
				// TODO Auto-generated method stub
				count++;
				return item + count;
			}
		};
	}
	
	@Bean
	public ItemProcessor<String, String> toRowwerCaseItemProcessor(){
		return (item) -> item.toLowerCase();
	}
}
