package nankisu.study.springbatch.eventlistener.batch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

public class MyWriterListener implements ItemWriteListener<Object> {

	@Override
	public void beforeWrite(List<? extends Object> items) {
		System.out.println("MyWriterListener - beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Object> items) {
		System.out.println("MyWriterListener - afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Object> items) {
		System.out.println("MyWriterListener - onWriteError");
	}

}
