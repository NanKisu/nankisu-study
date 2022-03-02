package nankisu.study.springbatch.flowjob.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyJobRunner implements ApplicationRunner{
	private final JobLauncher jobLauncher;
	private final Job myFlowJob2;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		jobLauncher.run(myFlowJob2, new JobParametersBuilder().toJobParameters());
	}

}
