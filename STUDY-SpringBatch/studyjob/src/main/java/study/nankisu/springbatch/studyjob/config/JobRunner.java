package study.nankisu.springbatch.studyjob.config;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JobRunner implements ApplicationRunner{
	private final Job job;
	private final JobLauncher jobLauncher;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		JobParameters jobParameters = new JobParametersBuilder()
			.addString("name", "nankisu")
			.addDate("runDate", new Date())
			.addLong("age", 29L)
			.addDouble("weight", 68.5)
			.toJobParameters();
		
		jobLauncher.run(job, jobParameters);
	}
}
