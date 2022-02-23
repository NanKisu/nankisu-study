package nankisu.study.springbatch.StepBuilderFactory;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class StepBuilderFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StepBuilderFactoryApplication.class, args);
	}

}
