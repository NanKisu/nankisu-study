package nankisu.study.springbatch.skip;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SkipApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkipApplication.class, args);
	}

}
