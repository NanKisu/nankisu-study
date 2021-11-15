package com.study.spring.springjpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.study.spring.springjpa.model.MyUser;
import com.study.spring.springjpa.repository.MyUserRepository;

@Service
public class MyUserService {
  @Autowired
  private MyUserRepository repository;
  
  @Transactional
  public MyUser createMyUser(MyUser myUser) {
    return repository.save(myUser);
  }
  
  @Transactional(readOnly = true)
  public MyUser getMyUser(Integer id) {
    return repository.findOne(id);
  }
  
  @Transactional(readOnly = true)
  public List<MyUser> getMyUsersAll() {
    return repository.findAll();
  }
  
  @Transactional(readOnly = true)
  public List<MyUser> findByAge(Integer age) {
    return repository.findByAge(age);
  }
  
  @Transactional(readOnly = true)
  public List<MyUser> findByName(String name) {
    Pageable pageable = new PageRequest(1, 1);
    return repository.findByName(name, pageable);
  }

  @Transactional
  public MyUser updateMyUser(MyUser myUser) {
    MyUser myUserEntity = getMyUser(myUser.getId());
    myUserEntity.setName(myUser.getName());
    myUserEntity.setAge(myUser.getAge());
    return myUserEntity;
  }
  
  @Transactional
  public void deleteMyUser(MyUser myUser) {
    repository.delete(myUser.getId());
  }
}
