package nankisu.study.springbatch.asyncprocessorwriter.config;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemWriterConfig {
	@Bean
	@StepScope
	public ItemWriter<String> syncItemWriter(){
		return new ItemWriter<String>() {
			@Override
			public void write(List<? extends String> items) throws Exception {
				Thread.sleep(100);
				System.out.println(items);
			}
		};
	}
	
	@Bean
	@StepScope
	public ItemWriter<Future<String>> asyncItemWriter(){
		AsyncItemWriter<String> asyncItemWriter = new AsyncItemWriter<String>();
		asyncItemWriter.setDelegate(syncItemWriter());
		return asyncItemWriter;
	}
}
