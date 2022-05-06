package nankisu.study.springbatch.flatfileitemwriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class FlatfileitemwriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlatfileitemwriterApplication.class, args);
	}

}
