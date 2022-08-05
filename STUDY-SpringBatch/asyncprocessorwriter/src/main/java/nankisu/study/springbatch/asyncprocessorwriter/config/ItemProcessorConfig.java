package nankisu.study.springbatch.asyncprocessorwriter.config;

import java.util.concurrent.Future;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class ItemProcessorConfig {
	@Bean
	@StepScope
	public ItemProcessor<Integer, String> syncItemProcessor(){
		return new ItemProcessor<Integer, String>() {
			@Override
			public String process(Integer item) throws Exception {
				return item.toString();
			}
		};
	}
	
	@Bean
	@StepScope
	public ItemProcessor<Integer, Future<String>> asyncItemProcessor(){
		AsyncItemProcessor<Integer, String> asyncItemProcessor = new AsyncItemProcessor<Integer, String>();
		asyncItemProcessor.setDelegate(syncItemProcessor());
		asyncItemProcessor.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return asyncItemProcessor;
	}
}
