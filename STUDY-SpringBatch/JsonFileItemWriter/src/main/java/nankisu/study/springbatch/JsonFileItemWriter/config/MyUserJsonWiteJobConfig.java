package nankisu.study.springbatch.JsonFileItemWriter.config;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.GsonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.JsonFileItemWriter.dto.UserDto;

@Configuration
@RequiredArgsConstructor
public class MyUserJsonWiteJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myUserWriteJob() {
		return jobBuilderFactory.get("myUserWriteJob")
				.start(myUserWriteStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myUserWriteStep() {
		return stepBuilderFactory.get("myUserWriterStep")
				.<UserDto, UserDto>chunk(5)
				.reader(myUserItemReader())
				.writer(myUserItemWriter())
				.build();
	}
	
	@Bean
	public ItemReader<UserDto> myUserItemReader(){
		return new ListItemReader<UserDto>(Arrays.asList(new UserDto("nankisu1", 1), new UserDto("nankisu2", 2)));
	}
	
	@Bean
	public ItemWriter<UserDto> myUserItemWriter(){
		return new JsonFileItemWriterBuilder<UserDto>()
				.name("myUserItemWriter")
				.resource(new FileSystemResource("C:\\Users\\nankisu\\eclipse-workspace-study\\JsonFileItemWriter\\src\\main\\resources\\myUserWriter.json"))
				.jsonObjectMarshaller(userJsonMarshaller())
				.build();
	}
	
	@Bean
	public JsonObjectMarshaller<UserDto> userJsonMarshaller(){
		return new GsonJsonObjectMarshaller<UserDto>();
	}
}
