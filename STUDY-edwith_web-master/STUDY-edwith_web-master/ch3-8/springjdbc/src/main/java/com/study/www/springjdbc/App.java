package com.study.www.springjdbc;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.www.springjdbc.config.ApplicationConfig;
import com.study.www.springjdbc.dao.RoleDao;
import com.study.www.springjdbc.dto.Role;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDao rd = ac.getBean(RoleDao.class);
        List<Role> roles = rd.selectAll();
        
        for(Role role : roles) {
        	System.out.println(role);
        }
        
//        Role roleInserted = new Role();
//        roleInserted.setRoleId(100);
//        roleInserted.setDescription("Role100");
//        
//        rd.insert(roleInserted);
        
//      Role roleUpdated = new Role();
//      roleUpdated.setRoleId(100);
//      roleUpdated.setDescription("Role100_Updated");
//
//      rd.update(roleUpdated);
       
        rd.deleteById(100);
        
        roles = rd.selectAll();
        
        for(Role role : roles) {
        	System.out.println(role);
        }
        
        
    }
}
