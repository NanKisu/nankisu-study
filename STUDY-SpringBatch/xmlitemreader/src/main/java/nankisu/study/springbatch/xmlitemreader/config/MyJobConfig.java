package nankisu.study.springbatch.xmlitemreader.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.xml.builder.StaxEventItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.xmlitemreader.dto.Person;

@Configuration
@RequiredArgsConstructor
public class MyJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myJob() {
		return jobBuilderFactory.get("myJob")
				.start(myStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myStep() {
		return stepBuilderFactory.get("myStep")
				.<Person, Person>chunk(3)
				.reader(myPersonReader())
				.writer(new MyPersonWriter())
				.build();
	}
	
	@Bean
	public ItemReader<Person> myPersonReader() {
		return new StaxEventItemReaderBuilder<Person>()
			.name("personItemReader")
			.resource(new ClassPathResource("persons.xml"))
			.addFragmentRootElements("person")
			.unmarshaller(personMarsharller())
			.build();
	}

	private Unmarshaller personMarsharller() {
		// TODO Auto-generated method stub
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("nankisu.study.springbatch.xmlitemreader.dto");
	    marshaller.setMappedClass(Person.class); // ADD THIS LINE
		return marshaller;
	}
}
