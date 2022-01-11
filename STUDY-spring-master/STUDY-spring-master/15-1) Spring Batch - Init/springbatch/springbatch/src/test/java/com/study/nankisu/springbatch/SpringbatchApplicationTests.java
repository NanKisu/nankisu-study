package com.study.nankisu.springbatch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.nankisu.springbatch.config.ImportFileConfig;
import com.study.nankisu.springbatch.dao.RoomDao;

@SpringBootTest
class SpringbatchApplicationTests {
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	Job job;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Bean
	public JobLauncherTestUtils jobLauncherTestUtils() {
		JobLauncherTestUtils utils = new JobLauncherTestUtils();
		utils.setJob(job);
		utils.setJobLauncher(jobLauncher);
		return utils;
	}
	
	@Test
	void contextLoads() throws Exception {
		System.out.println("job:" + job);
		System.out.println("jobLauncher:" + jobLauncher);
		
		assertThat(roomDao.getCount()).isEqualTo(0);
		Map<String, JobParameter> map = new HashMap<String, JobParameter>();
		map.put("filePath", new JobParameter("rooms.csv"));
		map.put("executedTime", new JobParameter("201511161000"));
		JobParameters params = new JobParameters(map);
		
		BatchStatus status = jobLauncherTestUtils().launchJob(params).getStatus();
		assertThat(status).isEqualTo(BatchStatus.COMPLETED);
		assertThat(roomDao.getCount()).isEqualTo(1);
	}

}
