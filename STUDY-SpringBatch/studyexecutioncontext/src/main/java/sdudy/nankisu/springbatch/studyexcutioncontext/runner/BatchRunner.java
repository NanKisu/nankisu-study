package sdudy.nankisu.springbatch.studyexecutioncontext.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BatchRunner implements ApplicationRunner{
	private final JobLauncher jobLauncher;
	private final Job job;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		jobLauncher.run(job, new JobParametersBuilder().addString("key", "3").toJobParameters());
	}
}
