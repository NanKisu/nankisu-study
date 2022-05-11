package nankisu.study.springbatch.JdbcBatchItemWriter.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.JdbcBatchItemWriter.dto.MyUserDto;

@Configuration
@RequiredArgsConstructor
public class MyJdbcBatchItemWriteJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final DataSource dataSource;
	
	@Bean
	public Job myJdbcBatchItemWriteJob() {
		return jobBuilderFactory.get("myJdbcBatchItemWriteJob")
				.start(myUserItemWriteStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myUserItemWriteStep() {
		return stepBuilderFactory.get("myUserItemWriteStep")
				.<MyUserDto, MyUserDto>chunk(5)
				.reader(myUserItemReader())
				.writer(myUserJdbcBatchItemWriter())
				.build();
	}
	
	@Bean
	public ItemReader<MyUserDto> myUserItemReader(){
		return new ListItemReader<MyUserDto>(Arrays.asList(new MyUserDto("nankisu1", 1), new MyUserDto("nankisu2", 2)));
	}
	
	@Bean
	public ItemWriter<MyUserDto> myUserJdbcBatchItemWriter(){
		return new JdbcBatchItemWriterBuilder<MyUserDto>()
				.dataSource(dataSource)
				.sql("INSERT INTO myuser(name, age) values(:name, :age)")
				.beanMapped()
				.build();
	}
}
