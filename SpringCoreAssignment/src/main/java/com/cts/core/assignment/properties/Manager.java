package com.cts.core.assignment.properties;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Manager implements Employee {



	@Value("${id}")
	private int id;
	
	@Value("${email}")
	private String email;
	
	@Override
	public void work() {
		// TODO Auto-generated method stub
		System.out.println("Manage the branch office");
	}


	public String getEmail() {
		return email;
	}


	public int getId() {
		return id;
	}

}
