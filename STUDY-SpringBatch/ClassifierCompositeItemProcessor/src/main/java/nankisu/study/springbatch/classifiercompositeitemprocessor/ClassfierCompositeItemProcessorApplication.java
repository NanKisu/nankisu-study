package nankisu.study.springbatch.classifiercompositeitemprocessor;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class ClassfierCompositeItemProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassfierCompositeItemProcessorApplication.class, args);
	}

}
