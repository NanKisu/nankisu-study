package nankisu.study.springbatch.jsonreader.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Data;

@Data
public class Person {
	private Integer age;
	private String name;
}
