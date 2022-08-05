package nankisu.study.springbatch.asyncprocessorwriter.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.support.SynchronizedItemStreamReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemReaderConfig {
	@Bean
	@StepScope
	public ItemStreamReader<Integer> syncItemReader(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10000; i++) {
			list.add(i);
		}
		return new ListItemStreamReader<Integer>(list);
	}
	
	@Bean
	@StepScope
	public ItemReader<Integer> asyncItemReader(){
		SynchronizedItemStreamReader<Integer> synchronizedItemStreamReader = new SynchronizedItemStreamReader<Integer>();
		synchronizedItemStreamReader.setDelegate(syncItemReader());
		return  synchronizedItemStreamReader;
	}
}
