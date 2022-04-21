package nankisu.study.springbatch.itemreaderadapter.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.itemreaderadapter.service.MyStringService;

@Configuration
@RequiredArgsConstructor
public class MyStringJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final MyStringService myStringService;
	
	@Bean
	public Job myStringJob() {
		return jobBuilderFactory.get("myStringJOb")
				.start(myStringStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myStringStep() {
		return stepBuilderFactory.get("myStringStep")
				.chunk(4)
				.reader(myStringReader())
				.writer((strings) -> {
					System.out.println(strings);
				})
				.build();
	}
	
	@Bean
	public ItemReader<String> myStringReader(){
	 	ItemReaderAdapter<String> itemReaderAdapter = new ItemReaderAdapter<String>();
	 	itemReaderAdapter.setTargetObject(myStringService);
	 	itemReaderAdapter.setTargetMethod("readString");
	 	return itemReaderAdapter;
	}
}
