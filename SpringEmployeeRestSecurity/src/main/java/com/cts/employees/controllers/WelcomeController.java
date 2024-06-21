package com.cts.employees.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @apiNote @RequestParam http://localhost:8080/employees?empId=1122
 * @PathVariable: http://localhost:8080/employees/1122
 */

@RestController
public class WelcomeController {

	@GetMapping // http://localhost:8080/
	public String greetings() {
		return "Hello From Spring Boot!";
	}

	@GetMapping("/greetings")
	public String personalizedGreetings(@RequestParam String name) {
		return "Welcome " + name;
	}
}
