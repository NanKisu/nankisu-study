package com.study.nankisu.springbatch.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class BatchController {
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@GetMapping("/run")
	public String runBatch(String filePath) {
		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("filePath", new JobParameter(filePath));
		map.put("executedTime", new JobParameter(LocalDateTime.now().toString()));
		JobParameters params = new JobParameters(map);
		try {
			jobLauncher.run(job, params);
			return "SUCCESS";
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
	}
}
