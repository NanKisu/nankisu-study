package nankisu.study.springbatch.jobscopestepscope.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class MyTasklet1 implements Tasklet {
	@Value("#{stepExecutionContext['age']}")
	private String age;
	
	public MyTasklet1() {
		System.out.println("MyTasklet1 constructor...");
	}
	
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("MyTasklet1 running...");
		System.out.println(age);
		return RepeatStatus.FINISHED;
	}
	
}