package nankisu.study.springbatch.eventlistener.batch.job;

import org.springframework.batch.core.SkipListener;

public class MySkipListener implements SkipListener<Object, Object> {

	@Override
	public void onSkipInRead(Throwable t) {
		System.out.println("MySkipListener - onSkipInRead");
	}

	@Override
	public void onSkipInWrite(Object item, Throwable t) {
		System.out.println("MySkipListener - onSkipInWrite");
	}

	@Override
	public void onSkipInProcess(Object item, Throwable t) {
		System.out.println("MySkipListener - onSkipInProcess");
	}

}
