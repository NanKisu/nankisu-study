package nankisu.study.springbatch.xmlitemreader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class XmlitemreaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlitemreaderApplication.class, args);
	}

}
