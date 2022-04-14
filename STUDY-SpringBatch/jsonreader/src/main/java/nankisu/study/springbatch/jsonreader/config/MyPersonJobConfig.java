package nankisu.study.springbatch.jsonreader.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.jsonreader.dto.Person;

@Configuration
@RequiredArgsConstructor
public class MyPersonJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myPersonJob() {
		return jobBuilderFactory.get("myPersonJob")
				.start(myPersonStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myPersonStep() {
		return stepBuilderFactory.get("myPersonStep")
				.chunk(5)
				.reader(personJsonReader())
				.writer((items) -> {
					System.out.println(items);
				})
				.build();
	}
	
	@Bean
	public ItemReader<? extends Person> personJsonReader(){
		return new JsonItemReaderBuilder<Person>()
				.name("personJsonReader")
				.resource(new ClassPathResource("person.json"))
				.jsonObjectReader(new JacksonJsonObjectReader<Person>(Person.class))
				.build();
	}
}
