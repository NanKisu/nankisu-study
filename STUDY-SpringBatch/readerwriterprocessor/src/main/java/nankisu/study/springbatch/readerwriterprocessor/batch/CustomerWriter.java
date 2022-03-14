package nankisu.study.springbatch.readerwriterprocessor.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter implements ItemStreamWriter<String>{
	private List<String> nameList;
	
	public CustomerWriter() {
		nameList = new ArrayList<String>();
	}
	
	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println(items);
		nameList.addAll(items);
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerWriter open...");
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerWriter update...");
		executionContext.putInt("isRestart", 1);
		for(String name : nameList) {
			executionContext.putInt(name, 1);
		}
	}

	@Override
	public void close() throws ItemStreamException {
		// TODO Auto-generated method stub
		System.out.println("CustomerWriter close...");
	}

}
