package nankisu.study.springbatch.flatfileitemreader.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import nankisu.study.springbatch.flatfileitemreader.vo.CustomerVo;


@Component
public class CustomerProcessor implements ItemProcessor<CustomerVo, String>{

	@Override
	public String process(CustomerVo item) throws Exception {
		return item.getName();
	}

}
