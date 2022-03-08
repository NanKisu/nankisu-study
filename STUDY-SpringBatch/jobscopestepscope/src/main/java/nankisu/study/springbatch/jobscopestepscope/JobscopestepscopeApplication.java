package nankisu.study.springbatch.jobscopestepscope;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobscopestepscopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobscopestepscopeApplication.class, args);
	}

}
