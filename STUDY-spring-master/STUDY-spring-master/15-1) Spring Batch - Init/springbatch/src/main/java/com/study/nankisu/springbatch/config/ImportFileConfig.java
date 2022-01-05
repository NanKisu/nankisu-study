package com.study.nankisu.springbatch.config;

import javax.batch.api.chunk.ItemWriter;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import com.study.nankisu.springbatch.dto.RoomDto;

@Lazy
@Configuration
@EnableBatchProcessing
public class ImportFileConfig {
	public static final String JOB_NAME = "importFileJob";
	@Autowired
	NamedParameterJdbcOperations jdbcTemplate;
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public JobParametersValidator jobParametersValidator() {
		String[] requiredKeys = new String[] {"filePath"};
		String[] optionalKeys = new String[] {"executedTime"};
		return new DefaultJobParametersValidator(requiredKeys, optionalKeys);
	}
	
	@Bean
	public MethodInvokingTaskletAdapter truncateTasklet() {
		MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();
		adapter.setTargetObject(truncateServive());
		adapter.setTargetMethod("excute");
		return adapter;
	}
	
	@Bean
	@Lazy
	public Job importFileJob() {
		return jobBuilderFactory.get(JOB_NAME)
				.validator(jobParametersValidator())
				.start(truncateStep())
				.next(importFileStep())
				.build();
	}
	
	@Bean
	public Step truncateStep() {
		return stepBuilderFactory.get("truncateStep")
				.tasklet(truncateTasklet())
				.build();
	}
	
	@Bean
	public Step importFileStep() {
		return stepBuilderFactory.get("importFileStep").<RoomDto, RoomDto>chunk(100)
				.reader(fileItemReader(null))
				.writer(dbItemWriter())
				.build();
	}
	
	@Bean
	@StepScope
	@Value("#{jobParameters['filePath']}")
	public FlatFileItemReader<RoomDto> fileItemReader(String filePath){
		System.out.println("filePath: " + filePath);
		FlatFileItemReader<RoomDto> reader = new FlatFileItemReader<RoomDto>();
		ResourceLoader loader = new DefaultResourceLoader();
		reader.setResource(loader.getResource(filePath));
		
		DefaultLineMapper<RoomDto> lineMapper = new DefaultLineMapper<RoomDto>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] {"roomId", "roomName", "capacity"});
		lineMapper.setLineTokenizer(lineTokenizer);
		
		BeanWrapperFieldSetMapper<RoomDto> fieldSetMapper = new BeanWrapperFieldSetMapper<RoomDto>();
		fieldSetMapper.setTargetType(RoomDto.class);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		reader.setLineMapper(lineMapper);
		reader.setLinesToSkip(1);
		return reader;
	}
	
	@Bean
	@StepScope
	public JdbcBatchItemWriter<RoomDto> dbItemWriter(){
		return new JdbcBatchItemWriterBuilder<RoomDto>().namedParametersJdbcTemplate(jdbcTemplate).sql("INSERT INTO ROOM VALUES(:roomId, :roomName, :capacity)").beanMapped().build();
	}
	
	@Bean
	public TruncateServive truncateServive() {
		return new TruncateServiceImpl();
	}
	
	public interface TruncateServive {
		ExitStatus excute();
	}
	
	public class TruncateServiceImpl implements TruncateServive {
		@Autowired
		JdbcTemplate jdbcTemplate;

		@Override
		public ExitStatus excute() {
			jdbcTemplate.execute("TRUNCATE TABLE room");
			return ExitStatus.COMPLETED;
		} 
	}
}
