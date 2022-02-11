package nankisu.study.springbatch.jobrepogitory;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobrepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobrepositoryApplication.class, args);
	}

}
