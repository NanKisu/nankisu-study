package nankisu.study.springbatch.transition;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class TransitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransitionApplication.class, args);
	}

}
