package nankisu.study.springbatch.jobstep;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobstepApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobstepApplication.class, args);
	}

}
