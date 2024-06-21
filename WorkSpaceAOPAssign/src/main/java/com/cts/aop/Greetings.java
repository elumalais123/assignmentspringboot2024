package com.cts.aop;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Greetings {

	 private static final Log log = LogFactory.getLog(Greetings.class);
	
	@Before("execution(* com.cts.aop.Person.work())")
	public void greeting() {
		System.out.println("Good Morning!!!");
		log.info("Logger debug");
	}
	@After("execution(* com.cts.aop.Person.work())")
	public void goodBye() {
		System.out.println("Good Bye!");
	}
	
	@Around("execution(* com.cts.aop.Person.work())")
	public void loginAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start=System.nanoTime();
		log.info("method -  from class  started with arguments ");
		
		Object obj=proceedingJoinPoint.proceed();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		long end=System.nanoTime();
		String methodName=proceedingJoinPoint.getSignature().getName();
		log.info("method - " + methodName + " from class - "+className + " started ");
				
		System.out.println(methodName+" took "+TimeUnit.NANOSECONDS.toMillis(end-start)+"ms of execution Time");
	}
}
