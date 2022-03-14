package nankisu.study.springbatch.readerwriterprocessor.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import nankisu.study.springbatch.readerwriterprocessor.vo.CustomerVo;

@Component
@JobScope
public class CustomerReader implements ItemStreamReader<CustomerVo>{
	private List<CustomerVo> customerList;
	
	public CustomerReader() {
		System.out.println("CustomerReader...");
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

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerReader open...");
		if(executionContext.containsKey("isRestart")) {
			customerList.removeIf((customer) -> executionContext.containsKey(customer.getName()));
		}
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerReader update...");
		
	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerReader close...");
		
	}

}
