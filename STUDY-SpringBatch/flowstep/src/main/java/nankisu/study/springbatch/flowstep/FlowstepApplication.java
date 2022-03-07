package nankisu.study.springbatch.flowstep;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FlowstepApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowstepApplication.class, args);
	}

}
