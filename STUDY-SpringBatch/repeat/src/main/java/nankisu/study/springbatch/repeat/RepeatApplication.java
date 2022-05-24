package nankisu.study.springbatch.repeat;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class RepeatApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepeatApplication.class, args);
	}

}
