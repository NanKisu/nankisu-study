package study.nankisu.springbatch.studystep.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
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
		// TODO Auto-generated method stub
		jobLauncher.run(job, new JobParametersBuilder().addDate("runDate", new Date()).toJobParameters());
	}
}
