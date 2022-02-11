package nankisu.study.springbatch.jobrepogitory.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyJobListener implements JobExecutionListener{
	private final JobRepository jobRepository;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		String jobName = jobExecution.getJobInstance().getJobName();
		JobParameters jobParameters = jobExecution.getJobParameters();
		System.out.println("jobName: " + jobName);
		
		JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
		StepExecution lastStep1Execution = jobRepository.getLastStepExecution(jobExecution.getJobInstance(), "myStep1");
		if(lastJobExecution != null) {
			System.out.println("lastJobExcution id: " + lastJobExecution.getId());
		}
		if(lastStep1Execution != null) {
			System.out.println("latStep1Execution id: " + lastStep1Execution.getId());
		}
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		String jobName = jobExecution.getJobInstance().getJobName();
		JobParameters jobParameters = jobExecution.getJobParameters();
		System.out.println("jobName: " + jobName);
		
		JobExecution lastJobExecution = jobRepository.getLastJobExecution(jobName, jobParameters);
		StepExecution lastStep1Execution = jobRepository.getLastStepExecution(jobExecution.getJobInstance(), "myStep1");
		if(lastJobExecution != null) {
			System.out.println("lastJobExcution id: " + lastJobExecution.getId());
		}
		if(lastStep1Execution != null) {
			System.out.println("latStep1Execution id: " + lastStep1Execution.getId());
		}
	}
}
