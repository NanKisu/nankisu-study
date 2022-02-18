package nankisu.study.springbatch.simplejob.vaildator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class MyJobValidator implements JobParametersValidator{

	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {
		// TODO Auto-generated method stub
		if(parameters.isEmpty()) {
			throw new JobParametersInvalidException("parameters IS EMPTY");
		}
	}

}
