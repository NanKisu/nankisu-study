package study.nankisu.springbatch.studyjob.config;

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
		jobLauncher.run(job, new JobParametersBuilder().addString("name", "user1").toJobParameters());
		//동일 JobParameter로 두 번 실행시, 에러 발생 
		//jobLauncher.run(job, new JobParametersBuilder().addString("name", "user1").toJobParameters());
	}
}
