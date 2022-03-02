package nankisu.study.springbatch.flowjob;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FlowjobApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowjobApplication.class, args);
	}

}
