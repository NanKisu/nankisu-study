package com.study.spring.springjpa.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import com.study.spring.springjpa.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
  @Query("SELECT user FROM #{#entityName} user where user.age = :age")
  public List<MyUser> findByAge(@Param("age") Integer age);
  public List<MyUser> findByName(String name, Pageable pageable);
}
