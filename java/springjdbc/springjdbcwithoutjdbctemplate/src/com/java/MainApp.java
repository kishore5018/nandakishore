package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("resource/spring.xml");
		EmpdaoImpl emp=(EmpdaoImpl)app.getBean("empdaoimpl");		
		Employee e=new Employee();
		/*e.setId(124);
		e.setUsername("saleem");
		e.setPassword("saleem78799");
		emp.insert(e);
		*/
		emp.fetch();
		/*e.setId(123);
		e.setUsername("avinash");
		e.setPassword("avinash789");
		emp.update(e);*/
	/*	e.setId(123);
		emp.delete(e);*/
	}
	
}
