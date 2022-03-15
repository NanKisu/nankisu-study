package nankisu.study.springbatch.flatfileitemreader.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.flatfileitemreader.vo.CustomerVo;

@Configuration
@RequiredArgsConstructor
public class CustomerReadJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	private final CustomerProcessor customerProcessor;
	private final CustomerWriter customerWriter;

	@Bean
	public Job customerReadJob() {
		return jobBuilderFactory.get("customerReadJob")
				.start(customerReadStep())
				.build();
	}
	
	@Bean
	public Step customerReadStep() {
		return stepBuilderFactory.get("customerReadStep")
				.<CustomerVo, String>chunk(5)
				.reader(customerFlatFileItemReader())
				.processor(customerProcessor)
				.writer(customerWriter)
				.build();
	}
	
	@Bean
	public ItemStreamReader<CustomerVo> customerFlatFileItemReader() {
		return new FlatFileItemReaderBuilder<CustomerVo>().name("customerFlatFileItemReader")
				.resource(new ClassPathResource("/customers.csv"))
				.linesToSkip(1)
				.lineMapper(new CustomerLineMapper(new DelimitedLineTokenizer(), new CustomerFieldSetMapper()))
				.build();
	}
}
