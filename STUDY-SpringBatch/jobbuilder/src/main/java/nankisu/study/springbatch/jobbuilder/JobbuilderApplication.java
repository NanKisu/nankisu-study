package nankisu.study.springbatch.jobbuilder;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobbuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobbuilderApplication.class, args);
	}

}
