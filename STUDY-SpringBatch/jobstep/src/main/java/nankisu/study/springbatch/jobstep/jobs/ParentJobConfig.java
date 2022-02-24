package nankisu.study.springbatch.jobstep.jobs;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;
import org.springframework.batch.core.step.job.JobParametersExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ParentJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final Job myJob;
	
	@Bean
	public Job myParentJob() {
		return jobBuilderFactory.get("myParentJob")
				.start(myJobStep())
				.build();
	}
	
	@Bean
	public Step myJobStep() {
		return stepBuilderFactory.get("myJobStep")
				.job(myJob)
				.parametersExtractor(defaultJobParametersExtractor())
				.listener(new StepExecutionListener() {
					@Override
					public void beforeStep(StepExecution stepExecution) {
						// TODO Auto-generated method stub
						stepExecution.getExecutionContext().put("age", 29);
					}
					
					@Override
					public ExitStatus afterStep(StepExecution stepExecution) {
						// TODO Auto-generated method stub
						return stepExecution.getExitStatus();
					}
				})
				.build();
	}
	
	private DefaultJobParametersExtractor defaultJobParametersExtractor() {
		DefaultJobParametersExtractor defaultJobParametersExtractor = new DefaultJobParametersExtractor();
		defaultJobParametersExtractor.setKeys(new String[] {"age"});
		return defaultJobParametersExtractor;
	}
}
