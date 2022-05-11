package nankisu.study.springbatch.JdbcBatchItemWriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JdbcBatchItemWriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcBatchItemWriterApplication.class, args);
	}

}
