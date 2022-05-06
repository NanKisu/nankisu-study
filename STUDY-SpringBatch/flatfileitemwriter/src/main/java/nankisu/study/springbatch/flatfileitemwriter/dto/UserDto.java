package nankisu.study.springbatch.flatfileitemwriter.dto;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private String name;
	private Integer age;
}
