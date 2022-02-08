package study.nankisu.springbatch.studystep;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class StudystepApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudystepApplication.class, args);
	}

}
