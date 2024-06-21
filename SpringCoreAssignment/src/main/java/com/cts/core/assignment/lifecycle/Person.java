package com.cts.core.assignment.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person {

	private String name;
	private Integer age;
	
	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@PostConstruct
	public void initMethod() {
		System.out.println("Inside Init Method...");
	}
	@PreDestroy
	public void destroyMethod() {
		System.out.println("Inside destroy Method!!!");
	}
}
