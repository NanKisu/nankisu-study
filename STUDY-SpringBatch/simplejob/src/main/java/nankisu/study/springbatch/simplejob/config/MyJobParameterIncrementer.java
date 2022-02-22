package nankisu.study.springbatch.simplejob.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class MyJobParameterIncrementer implements JobParametersIncrementer{
	@Override
	public JobParameters getNext(JobParameters parameters) {
		// TODO Auto-generated method stub
		long id = LocalDateTime.now().toEpochSecond(ZoneOffset.MIN);
		return new JobParametersBuilder(parameters).addLong("id", id).toJobParameters();
	}

}
