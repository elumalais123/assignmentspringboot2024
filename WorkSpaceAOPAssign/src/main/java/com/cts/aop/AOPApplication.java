package com.cts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AOPApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		Person person=context.getBean(Person.class);
		person.work();
		
		context.close();
	}
}
