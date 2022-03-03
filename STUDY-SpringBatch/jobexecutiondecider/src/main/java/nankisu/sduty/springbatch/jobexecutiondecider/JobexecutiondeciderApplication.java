package nankisu.sduty.springbatch.jobexecutiondecider;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobexecutiondeciderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobexecutiondeciderApplication.class, args);
	}

}
