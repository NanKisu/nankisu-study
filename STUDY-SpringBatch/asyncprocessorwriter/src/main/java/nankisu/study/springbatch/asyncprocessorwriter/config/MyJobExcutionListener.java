package nankisu.study.springbatch.asyncprocessorwriter.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class MyJobExcutionListener implements JobExecutionListener {
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println(jobExecution.getJobInstance().getJobName() + " " + (jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime()));
	}
}
