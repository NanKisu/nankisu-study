package com.study.springjdbc.springjdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springjdbc.config.AppContext;
import com.study.springjdbc.dao.Noun001DAO;
import com.study.springjdbc.service.NounService;
import com.study.springjdbc.vo.Noun001;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
//    	Noun001DAO dao = context.getBean(Noun001DAO.class);
//    	
//    	System.out.println(dao.selectAll());
//    	
//    	Noun001 noun = new Noun001();
//    	noun.setSysC("001");
//    	noun.setValue("멍멍이");
//    	Integer id = dao.insert(noun);
//    	
//    	System.out.println(dao.selectById(id));
//    	
//    	dao.updateById(id, "고양이");
//
//    	System.out.println(dao.selectAll());
//    	
//    	dao.deleteById(id);
//    	
//    	System.out.println(dao.selectAll());
    	
    	NounService service = context.getBean(NounService.class);
    	service.test2();
    }
}
