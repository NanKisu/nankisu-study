package com.study.springj.vo;

public class Noun001 {
	private String sysC;
	private Integer id;
	private String value;
	
	public String getSysC() {
		return sysC;
	}
	public void setSysC(String sysC) {
		this.sysC = sysC;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Noun001 [sysC=" + sysC + ", id=" + id + ", value=" + value + "]";
	}
}
