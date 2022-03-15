package nankisu.study.springbatch.flatfileitemreader.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import nankisu.study.springbatch.flatfileitemreader.vo.CustomerVo;

public class CustomerFieldSetMapper implements FieldSetMapper<CustomerVo>{

	@Override
	public CustomerVo mapFieldSet(FieldSet fieldSet) throws BindException {
		return CustomerVo.builder()
				.name(fieldSet.readRawString(0))
				.age(fieldSet.readInt(1))
				.build();
	}

}
