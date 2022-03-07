package nankisu.study.springbatch.simpleflow;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SimpleflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleflowApplication.class, args);
	}

}
