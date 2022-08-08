package nankisu.study.springbatch.asyncprocessorwriter.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PartitionJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job partitionJob() {
		return jobBuilderFactory.get("partitionJob")
				.start(partitionStep())
				.build();
	}
	
	@Bean
	public Step partitionStep() {
		return stepBuilderFactory.get("partitionStep")
				.partitioner("masterStep", new MyPartitioner())
				.step(slaveStep())
				.gridSize(4)
				.build();
	}

	@Bean
	public Step slaveStep() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("slaveStep")
				.tasklet((contribution, context) -> {
					int start = contribution.getStepExecution().getExecutionContext().getInt("start");
					System.out.println(start);
					return RepeatStatus.FINISHED;
				})
				.build();
	}
}
