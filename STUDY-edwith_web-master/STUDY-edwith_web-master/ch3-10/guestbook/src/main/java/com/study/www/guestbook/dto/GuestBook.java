package com.study.www.guestbook.dto;

import java.util.Date;

public class GuestBook {
	private Long id;
	private String name;
	private String content;
	private Date regdate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate + "]";
	}
}
