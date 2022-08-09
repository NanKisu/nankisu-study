package nankisu.study.springbatch.eventlistener;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class EventlistenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventlistenerApplication.class, args);
	}

}
