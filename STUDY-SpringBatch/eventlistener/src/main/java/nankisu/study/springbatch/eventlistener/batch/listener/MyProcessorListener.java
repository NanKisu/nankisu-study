package nankisu.study.springbatch.eventlistener.batch.listener;

import org.springframework.batch.core.ItemProcessListener;

public class MyProcessorListener implements ItemProcessListener<Object, Object> {

	@Override
	public void beforeProcess(Object item) {
		System.out.println("MyProcessorListener - beforeProcess");
	}

	@Override
	public void afterProcess(Object item, Object result) {
		System.out.println("MyProcessorListener - afterProcess");
	}

	@Override
	public void onProcessError(Object item, Exception e) {
		System.out.println("MyProcessorListener - onProcessError");
	}

}
