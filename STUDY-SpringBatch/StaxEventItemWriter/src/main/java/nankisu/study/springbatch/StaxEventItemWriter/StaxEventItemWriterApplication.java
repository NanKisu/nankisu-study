package nankisu.study.springbatch.StaxEventItemWriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class StaxEventItemWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaxEventItemWriterApplication.class, args);
	}

}
