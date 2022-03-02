package nankisu.study.springbatch.flowjob.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyFlowJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myFlowJob2() {
		return jobBuilderFactory.get("myFlowJob2")
				.start(myJobFlow1())
				.next(myFlowJobsStep3())
				.next(myJobFlow2())
				.end()
				.build();
	}
	
	@Bean
	public Flow myJobFlow1() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myJobFlow1");
		return flowBuilder
				.start(myFlowJobsStep1())
				.next(myFlowJobsStep2())
				.build();
	}
	
	@Bean
	public Flow myJobFlow2() {
		FlowBuilder<Flow> flowBuilder = new FlowBuilder<Flow>("myJobFlow2");
		return flowBuilder
				.start(myFlowJobsStep4())
				.next(myFlowJobsStep5())
				.build();
	}
	
	@Bean
	public Step myFlowJobsStep1() {
		return stepBuilderFactory.get("myFlowJobsStep1")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myFlowJobsStep1 running...");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	@Bean
	public Step myFlowJobsStep2() {
		return stepBuilderFactory.get("myFlowJobsStep2")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myFlowJobsStep2 running...");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	@Bean
	public Step myFlowJobsStep3() {
		return stepBuilderFactory.get("myFlowJobsStep3")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myFlowJobsStep3 running...");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	@Bean
	public Step myFlowJobsStep4() {
		return stepBuilderFactory.get("myFlowJobsStep4")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myFlowJobsStep4 running...");
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
	@Bean
	public Step myFlowJobsStep5() {
		return stepBuilderFactory.get("myFlowJobsStep5")
				.tasklet(new Tasklet() {
					@Override
					public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
						System.out.println("myFlowJobsStep5 running...");
//						throw new Exception();
						return RepeatStatus.FINISHED;
					}
				})
				.build();
	}
}
