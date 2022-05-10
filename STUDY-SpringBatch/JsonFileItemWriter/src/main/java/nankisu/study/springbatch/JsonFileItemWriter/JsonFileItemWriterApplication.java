package nankisu.study.springbatch.JsonFileItemWriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JsonFileItemWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonFileItemWriterApplication.class, args);
	}

}
