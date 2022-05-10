package nankisu.study.springbatch.StaxEventItemWriter.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.GsonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonObjectMarshaller;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.StaxEventItemWriter.dto.UserDto;

@Configuration
@RequiredArgsConstructor
public class MyUserWriteJobConfig {
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
		return stepBuilderFactory.get("myUserWriteStep")
				.<UserDto, UserDto>chunk(5)
				.reader(myUserItemReader())
				.writer(myUserWriter())
				.build();
	}
	
	@Bean
	public ItemReader<UserDto> myUserItemReader(){
		return new ListItemReader<UserDto>(Arrays.asList(new UserDto("nankisu1", 1), new UserDto("nankisu2", 2)));
	}
	
	@Bean
	public ItemWriter<UserDto> myUserWriter(){
		return new StaxEventItemWriterBuilder<UserDto>()
				.name("myUserWriter")
				.resource(new FileSystemResource("C:\\Users\\nankisu\\eclipse-workspace-study\\StaxEventItemWriter\\src\\main\\resources\\myUserWriter.xml"))
				.rootTagName("User")
				.marshaller(userMarshaller())
				.build();
	}
	
	@Bean
	public Marshaller userMarshaller(){
		Map<String,Class<?>> aliasesMap = new HashMap<String, Class<?>>();
		aliasesMap.put("User", UserDto.class);
		aliasesMap.put("name", String.class);
		aliasesMap.put("age", Integer.class);
		  
		XStreamMarshaller userMarshaller = new XStreamMarshaller();
		userMarshaller.setAliases(aliasesMap);
		return userMarshaller;
	}
}
