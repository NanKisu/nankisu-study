package nankisu.study.springbatch.flatfileitemreader.batch;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;

import lombok.RequiredArgsConstructor;
import nankisu.study.springbatch.flatfileitemreader.vo.CustomerVo;

@RequiredArgsConstructor
public class CustomerLineMapper implements LineMapper<CustomerVo>{
	private final LineTokenizer lineTokenizer;
	private final FieldSetMapper<CustomerVo> fieldSetMapper;
	
	@Override
	public CustomerVo mapLine(String line, int lineNumber) throws Exception {
		FieldSet fieldSet = lineTokenizer.tokenize(line);
		CustomerVo customer = fieldSetMapper.mapFieldSet(fieldSet);
		return customer;
	}

}
