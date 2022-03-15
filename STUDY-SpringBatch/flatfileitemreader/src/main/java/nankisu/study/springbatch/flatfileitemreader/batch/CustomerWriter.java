package nankisu.study.springbatch.flatfileitemreader.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter implements ItemWriter<String>{
	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println(items);
	}

}
