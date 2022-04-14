package nankisu.study.springbatch.jsonreader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JsonreaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonreaderApplication.class, args);
	}

}
