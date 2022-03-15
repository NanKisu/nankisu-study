package nankisu.study.springbatch.flatfileitemreader.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CustomerVo {
	private String name;
	private int age;
}
