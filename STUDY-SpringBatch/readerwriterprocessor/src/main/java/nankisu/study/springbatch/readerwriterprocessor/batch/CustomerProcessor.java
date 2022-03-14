package nankisu.study.springbatch.readerwriterprocessor.batch;

import java.util.Random;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import nankisu.study.springbatch.readerwriterprocessor.vo.CustomerVo;

@Component
public class CustomerProcessor implements ItemProcessor<CustomerVo, String>{

	@Override
	public String process(CustomerVo item) throws Exception {
		int ran = new Random(System.currentTimeMillis()).nextInt(10);
		if(ran < 3) {
			throw new Exception("ran < 3");
		}
		return item.getName();
	}

}
