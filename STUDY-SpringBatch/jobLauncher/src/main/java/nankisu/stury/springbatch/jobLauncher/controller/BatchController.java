package nankisu.stury.springbatch.jobLauncher.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchController {
	private final JobLauncher jobLauncher;
	private final JobLauncher asyncJobLauncher;
	private final Job job;
	
	@GetMapping("/run")
	public String run(@RequestParam String name) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		jobLauncher.run(job, new JobParametersBuilder().addString("name", name).toJobParameters());
		return "SUCCESS";
	}
	
	@GetMapping("/async-run")
	public String asyncRun(@RequestParam String name) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		asyncJobLauncher.run(job, new JobParametersBuilder().addString("name", name).toJobParameters());
		return "SUCCESS";
	}
}
