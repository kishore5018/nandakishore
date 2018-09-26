package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("resource/spring.xml");
		EmpdaoImpl emp=(EmpdaoImpl)app.getBean("empdaoimpl");
		Employee e=new Employee();
//		e.setId(125);
		/*e.setUsername("kishore8888");
		e.setPassword("kishore7777");
		emp.update(e);
		*/
emp.fetch();
	
	
	
	}
	

}
