package nankisu.study.springbatch.eventlistener.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("MyJobListener - beforeJob");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("MyJobListener - afterJob");
	}

}
