package com.cts.core.assignment;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.core.assignment.empauto.Employee;
import com.cts.core.assignment.lifecycle.Person;
import com.cts.core.assignment.properties.AppConfig;
import com.cts.core.assignment.properties.Manager;

 
public class SpringLearnApplication {
     
    @SuppressWarnings("resource")
    public static void main(String[] args) {
     
    	//SimpleDateFormat assignment
    		System.out.println("-----------------------SimpleDateFormat--------------------------");
            ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
             
            SimpleDateFormat dateDisplay = (SimpleDateFormat) context.getBean("dateFormat");
             
            System.out.println("Date is : " + dateDisplay.format(new Date()));
            
    	//Autowired
            System.out.println("-----------------------Autowired--------------------------");
            ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
            
            Employee emp = (Employee) ctx.getBean("employee");
            System.out.println(emp.getEmpaddress());
    	//Bean Lifecycle
    	
            System.out.println("-----------------------Bean Lifecycle--------------------------");
    	 AbstractApplicationContext ctx3= new ClassPathXmlApplicationContext("beanLifeCycle.xml");
    	   Person person = (Person) ctx3.getBean("person");
    	   System.out.println(person);
    	   //registering shutdown hook
    	   ctx3.registerShutdownHook(); 

    	   System.out.println("-----------------------Bean Properties--------------------------");
    	//Create Properties read the value
    	AnnotationConfigApplicationContext context4=new AnnotationConfigApplicationContext(AppConfig.class);
    	Manager manager=context4.getBean(Manager.class);
    	manager.work();
    	System.out.println("Id :"+manager.getId());
    	System.out.println("Manager Email :"+manager.getEmail());
    	
    	context4.close();
    	
    	//Bean Inheritance 
    	System.out.println("-----------------------Bean Inheritance--------------------------");
    	
    	
    }
}