package com.study.argumentresolver.vo;

import java.util.HashMap;
import java.util.Map;

public class HeaderInfo {
	private Map<String, String> map;
	
	public HeaderInfo() {
		map = new HashMap<>();
	}

	public void put(String name, String value) {
		map.put(name,  value);
	}
	
	public String get(String name) {
		return map.get(name);
	}

	@Override
	public String toString() {
		return "HeaderInfo [map=" + map + "]";
	}
}