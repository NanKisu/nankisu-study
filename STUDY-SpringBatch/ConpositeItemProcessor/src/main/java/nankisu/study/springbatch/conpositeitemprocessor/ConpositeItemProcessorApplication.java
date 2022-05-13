package nankisu.study.springbatch.conpositeitemprocessor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ConpositeItemProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConpositeItemProcessorApplication.class, args);
	}

}
