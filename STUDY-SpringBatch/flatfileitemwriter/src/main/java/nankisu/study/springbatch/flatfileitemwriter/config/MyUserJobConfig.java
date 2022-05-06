package nankisu.study.springbatch.flatfileitemwriter.config;

import java.util.Arrays;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.flatfileitemwriter.dto.UserDto;

@Configuration
@RequiredArgsConstructor
public class MyUserJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myUserJob() {
		return jobBuilderFactory.get("myUserJob")
				.start(myUserStep1())
				.next(myUserStep2())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myUserStep1() {
		return stepBuilderFactory.get("myUserStep1")
				.<UserDto, UserDto>chunk(5)
				.reader(myUserItemReader())
				.writer(myUserItemWriter1())
				.build();
	}
	
	@Bean
	public Step myUserStep2() {
		return stepBuilderFactory.get("myUserStep2")
				.<UserDto, UserDto>chunk(1)
				.reader(myUserItemReader())
				.writer(myUserItemWriter2())
				.build();
	}
	
	@Bean
	@StepScope
	public ItemReader<UserDto> myUserItemReader(){
		return new ListItemReader<UserDto>(Arrays.asList(new UserDto("nankisu1", 1), new UserDto("nankisu2", 2)));
	}
	
	@Bean
	public ItemWriter<UserDto> myUserItemWriter1(){
		return new FlatFileItemWriterBuilder<UserDto>().name("myUserItemWriter1")
				.resource(new FileSystemResource("C:\\Users\\nankisu\\eclipse-workspace-study\\flatfileitemwriter\\src\\main\\resources\\myUserItemWriter1.txt"))
				.delimited().delimiter(",")
				.names(new String[]{"name", "age"})
				.build();
	}
	
	@Bean
	public ItemWriter<UserDto> myUserItemWriter2(){
		return new FlatFileItemWriterBuilder<UserDto>().name("myUserItemWriter2")
				.resource(new FileSystemResource("C:\\Users\\nankisu\\eclipse-workspace-study\\flatfileitemwriter\\src\\main\\resources\\myUserItemWriter2.txt"))
				.formatted().format("%-5s, %-3d")
				.names(new String[]{"name", "age"})
				.build();
	}
}
