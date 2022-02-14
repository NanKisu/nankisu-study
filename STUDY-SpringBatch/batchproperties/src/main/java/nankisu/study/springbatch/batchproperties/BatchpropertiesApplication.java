package nankisu.study.springbatch.batchproperties;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchpropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchpropertiesApplication.class, args);
	}

}
