package nankisu.stury.springbatch.jobLauncher;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobLauncherApplication.class, args);
	}

}
