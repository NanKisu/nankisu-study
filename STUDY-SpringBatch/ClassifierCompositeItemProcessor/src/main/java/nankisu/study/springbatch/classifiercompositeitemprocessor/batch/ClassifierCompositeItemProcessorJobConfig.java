package nankisu.study.springbatch.classifiercompositeitemprocessor.batch;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ClassifierCompositeItemProcessorJobConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job myIntegerDescriptionJob() {
		return jobBuilderFactory.get("myIntegerDescriptionJob")
				.start(myIntegerDescriptionStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myIntegerDescriptionStep() {
		return stepBuilderFactory.get("myIntegerDescriptionStep")
				.<Integer, String>chunk(5)
				.reader(new ListItemReader<Integer>(List.of(1,2,3,4,5,6)))
				.processor(myNumberItemProcessor())
				.writer((item) -> {
					System.out.println(item);
				})
				.build();
	}
	
	@Bean
	public ItemProcessor<Integer, String> myNumberItemProcessor(){
		return new ClassifierCompositeItemProcessorBuilder<Integer, String>()
			.classifier(new Classifier<Integer,ItemProcessor<?,? extends String>>() {
				private static final long serialVersionUID = 1L;

				@Override
				public ItemProcessor<Integer, String> classify(Integer classifiable) {
					if(classifiable % 2 == 0) {
						return evenItemProcessor();
					}
					return oddItemProcessor();
				}
			})
			.build();
	}
	
	@Bean
	public ItemProcessor<Integer, String> oddItemProcessor(){
		return (item) -> item + " is odd number.";
	}
	
	@Bean
	public ItemProcessor<Integer, String> evenItemProcessor(){
		return (item) -> item + " is even number.";
	}
}
