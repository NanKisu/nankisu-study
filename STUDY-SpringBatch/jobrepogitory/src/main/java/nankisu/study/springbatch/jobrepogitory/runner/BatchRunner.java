package nankisu.study.springbatch.jobrepogitory.runner;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BatchRunner implements ApplicationRunner{
	private final JobLauncher jobLauncher;
	private final Job job;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		jobLauncher.run(job, new JobParametersBuilder().addDate("dateKey", new Date()).toJobParameters());
	}

}
