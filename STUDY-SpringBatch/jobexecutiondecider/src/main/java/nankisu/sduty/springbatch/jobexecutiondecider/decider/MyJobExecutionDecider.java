package nankisu.sduty.springbatch.jobexecutiondecider.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

public class MyJobExecutionDecider implements JobExecutionDecider{

	@Override
	public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
		int ran = jobExecution.getExecutionContext().getInt("ran");
		if(ran >= 5) {
			return new FlowExecutionStatus("OVER5");
		}
		else {			
			return new FlowExecutionStatus("UNDER5");
		}
	}

}
