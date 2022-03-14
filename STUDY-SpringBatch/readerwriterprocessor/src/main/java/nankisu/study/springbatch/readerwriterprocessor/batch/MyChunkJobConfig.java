package nankisu.study.springbatch.readerwriterprocessor.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.readerwriterprocessor.vo.CustomerVo;

@Configuration
@RequiredArgsConstructor
public class MyChunkJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	private final CustomerReader customerReader;
	private final CustomerProcessor customerProcessor;
	private final CustomerWriter customerWriter;
	
	@Bean
	public Job customerJob1() {
		return jobBuilderFactory.get("customerJob1")
				.start(customerChunkStep())
				//.incrementer(new RunIdIncrementer())
				.build();
	}

	@Bean
	public Job customerJob2() {
		return jobBuilderFactory.get("customerJob2")
				.start(customerChunkStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step customerChunkStep() {
		return stepBuilderFactory.get("customerChunkStep")
				.<CustomerVo, String>chunk(3)
				.reader(customerReader)
				.processor(customerProcessor)
				.writer(customerWriter)
				.build();
	}
}
