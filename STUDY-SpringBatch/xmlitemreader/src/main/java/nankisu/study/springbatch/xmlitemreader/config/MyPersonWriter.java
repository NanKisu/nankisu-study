package nankisu.study.springbatch.xmlitemreader.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import nankisu.study.springbatch.xmlitemreader.dto.Person;

public class MyPersonWriter implements ItemWriter<Person> {

	@Override
	public void write(List<? extends Person> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(items);
	}

}
