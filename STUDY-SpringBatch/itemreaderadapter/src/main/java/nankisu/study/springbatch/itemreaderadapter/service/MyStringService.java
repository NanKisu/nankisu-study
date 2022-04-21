package nankisu.study.springbatch.itemreaderadapter.service;

import org.springframework.stereotype.Service;

@Service
public class MyStringService {
	private int cnt = 0;
	
	public String readString() {
		if(cnt < 10) {
			return "myString" + cnt++;
		}
		else {
			return null;
		}
	}
}
