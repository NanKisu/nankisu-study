package nankisu.study.springbatch.itemreaderadapter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ItemreaderadapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemreaderadapterApplication.class, args);
	}

}
