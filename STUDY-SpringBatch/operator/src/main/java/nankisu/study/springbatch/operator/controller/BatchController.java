package nankisu.study.springbatch.operator.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchController {
	private final JobOperator jobOperator;
	private final JobRegistry jobRegistry;
	private final JobExplorer jobExplorer;
	
	@GetMapping("/start")
	public String jobStart(String data) throws NoSuchJobException, JobInstanceAlreadyExistsException, JobParametersInvalidException {
		for(String jobName : jobRegistry.getJobNames()) {
			 jobOperator.start(jobName, "data="+data);
		}
		return "SUCCESS";
	}
	
	@GetMapping("/restart")
	public String jobRestart(String data) throws JobInstanceAlreadyCompleteException, NoSuchJobExecutionException, NoSuchJobException, JobRestartException, JobParametersInvalidException {
		for(String jobName : jobRegistry.getJobNames()) {
			Long executionId = jobExplorer.getLastJobExecution(jobExplorer.getLastJobInstance(jobName)).getId();
			jobOperator.restart(executionId);
		}
		return "SUCCESS";
	}
	
	@GetMapping("/stop")
	public String jobStop() throws NoSuchJobExecutionException, JobExecutionNotRunningException  {
		for(String jobName : jobRegistry.getJobNames()) {
			for(JobExecution jobExecution : jobExplorer.findRunningJobExecutions(jobName)) {				
				jobOperator.stop(jobExecution.getId());
			}
		}
		return "SUCCESS";
	}
}
