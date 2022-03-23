package nankisu.study.springbatch.xmlitemreader.dto;

import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Data;

@Data
@XmlSeeAlso(Person.class)
public class Person {
	private Integer age;
	private String name;
}
