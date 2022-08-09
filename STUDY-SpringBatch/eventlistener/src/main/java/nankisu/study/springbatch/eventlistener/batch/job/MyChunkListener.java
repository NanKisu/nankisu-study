package nankisu.study.springbatch.eventlistener.batch.job;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;

public class MyChunkListener implements ChunkListener {

	@Override
	public void beforeChunk(ChunkContext context) {
		System.out.println("MyChunkListener - beforeChunk");
	}

	@Override
	public void afterChunk(ChunkContext context) {
		System.out.println("MyChunkListener - afterChunk");
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		System.out.println("MyChunkListener - afterChunkError");
	}

}
