package com.study.java.version.v10;

public class StudyLocalVariableReferer {
	public static void main(String[] args) {
		// String str = "hello"; 기존의 변수 선언
		var str = "hello";
		System.out.println(str.getClass().getTypeName());
	}
}
