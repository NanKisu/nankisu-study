package sdudy.nankisu.springbatch.studyexecutioncontext.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class MyTasklet4 implements Tasklet{

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("running MyTasklet4");
		ExecutionContext jobExecutionContext = contribution.getStepExecution().getJobExecution().getExecutionContext();
		ExecutionContext stepExecutionContext = contribution.getStepExecution().getExecutionContext();
		
		String jobName = contribution.getStepExecution().getJobExecution().getJobInstance().getJobName();
		String stepName = contribution.getStepExecution().getStepName();
		
		if(jobExecutionContext.get("jobName") == null) {
			System.out.println("put jobName");
			jobExecutionContext.put("jobName", jobName);
		}
		
		if(stepExecutionContext.get("stepName") == null) {
			System.out.println("put stepName");
			jobExecutionContext.put("putStepName4", true);
			stepExecutionContext.put("stepName", stepName);
		}
		return RepeatStatus.FINISHED;
	}

}
