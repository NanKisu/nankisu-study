package nankisu.study.springbatch.ItemWriterAdapter.config;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.ItemWriterAdapter.dto.MyUserDto;
import nankisu.study.springbatch.ItemWriterAdapter.service.MyUserService;

@Configuration
@RequiredArgsConstructor
public class MyItemWriterAdapterJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final MyUserService myUserService;
	
	@Bean
	public Job myItemWriteJob() {
		return jobBuilderFactory.get("myItemWriteJob")
				.start(myUserItemWriteStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myUserItemWriteStep() {
		return stepBuilderFactory.get("myUserItemWriteStep")
				.<MyUserDto, MyUserDto>chunk(5)
				.reader(myUserItemReader())
				.writer(myUserItemAdapterWriter())
				.build();
	}
	
	@Bean
	public ItemReader<MyUserDto> myUserItemReader(){
		return new ListItemReader<MyUserDto>(Arrays.asList(new MyUserDto("nankisu1", 1), new MyUserDto("nankisu2", 2)));
	}
	
	@Bean
	public ItemWriter<MyUserDto> myUserItemAdapterWriter(){
		ItemWriterAdapter<MyUserDto> itemWriterAdapter = new ItemWriterAdapter<MyUserDto>();
		itemWriterAdapter.setTargetObject(myUserService);
		itemWriterAdapter.setTargetMethod("insert");
		return itemWriterAdapter;
	}
}
