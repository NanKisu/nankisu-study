package nankisu.study.springbatch.readerwriterprocessor.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import nankisu.study.springbatch.readerwriterprocessor.vo.CustomerVo;

@Component
@JobScope
public class CustomerReader implements ItemReader<CustomerVo>{
	private List<CustomerVo> customerList;
	
	public CustomerReader() {
		customerList = new ArrayList<CustomerVo>();
		for(int i = 0; i < 10; i++) {
			String name = new StringBuffer("nankisu").append(i).toString();
			CustomerVo customer = CustomerVo.builder().name(name).build();
			customerList.add(customer);
		}
	}
	
	@Override
	public CustomerVo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		if(customerList.isEmpty()) {
			return null;
		}
		return customerList.remove(0);
	}

}
