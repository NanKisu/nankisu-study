package nankisu.study.springbatch.flowjob.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final Step myStep1;
	private final Step myStep2;
	private final Step myStep3;
	
	@Bean
	public Job myFlowJob() {
		return jobBuilderFactory.get("myFlowJob")
				.start(myStep1)
				.on(ExitStatus.COMPLETED.getExitCode()).to(myStep2)
				.from(myStep1)
				.on(ExitStatus.FAILED.getExitCode()).to(myStep3)
				.end()
				.build();
	}
}
