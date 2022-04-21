package nankisu.study.springbatch.jdbccursoritemreader.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.jdbccursoritemreader.dto.RoomDto;

@Configuration
@RequiredArgsConstructor
public class MyJdbcCursorReaderConfig {
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final DataSource dataSource;
	
	@Bean
	public Job myRoomJob() {
		return jobBuilderFactory.get("myRoomJob")
				.start(myRoomStep())
				.incrementer(new RunIdIncrementer())
				.build();
	}
	
	@Bean
	public Step myRoomStep() {
		return stepBuilderFactory.get("myRoomStep")
				.chunk(4)
				.reader(jdbcCursorItemReader())
				.writer((rooms) -> {
					System.out.println(rooms);
				})
				.build();
	}
	
	@Bean
	public ItemReader<RoomDto> jdbcCursorItemReader(){
		return new JdbcCursorItemReaderBuilder<RoomDto>()
				.name("jdbcCursorItemReader")
				.fetchSize(4)
				.dataSource(dataSource)
				.sql("SELECT room_id, room_name, capacity FROM room")
				.beanRowMapper(RoomDto.class)
				.currentItemCount(4)
				.maxRows(10)
				.build();
	}
}
