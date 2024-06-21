package com.cts.aop;

import org.springframework.stereotype.Component;

@Component
public class Person {

	public void work() {
		System.out.println("Person Works on a project");
	}
	
	public void login() {
		System.out.println("Login Works");
	}
}
