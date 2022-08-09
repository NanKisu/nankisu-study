package nankisu.study.springbatch.eventlistener.batch.listener;

import org.springframework.batch.core.ItemReadListener;

public class MyReaderListener implements ItemReadListener<Object> {

	@Override
	public void beforeRead() {
		System.out.println("MyReaderListener - beforeRead");
	}
	
	@Override
	public void afterRead(Object item) {
		System.out.println("MyReaderListener - afterRead");
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("MyReaderListener - onReadError");
	}

}
