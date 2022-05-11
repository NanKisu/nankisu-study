package nankisu.study.springbatch.ItemWriterAdapter.service;

import org.springframework.stereotype.Service;

import nankisu.study.springbatch.ItemWriterAdapter.dto.MyUserDto;

@Service
public class MyUserService {
	public void insert(MyUserDto myUser) {
		System.out.println(myUser.getName());
		System.out.println(myUser.getAge());
	}
}
