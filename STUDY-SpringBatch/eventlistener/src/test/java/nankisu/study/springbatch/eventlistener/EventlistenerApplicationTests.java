package nankisu.study.springbatch.eventlistener;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import nankisu.study.springbatch.eventlistener.batch.job.MyJobConfig;


@SpringBatchTest
@SpringBootTest(classes = {MyJobConfig.class, TestBatchConfig.class})
class EventlistenerApplicationTests {
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	void jobLauchTest() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob(new JobParametersBuilder().addLong("launchDate", LocalDate.now().toEpochDay()).toJobParameters());
		assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo(ExitStatus.FAILED.getExitCode());
	}

}
