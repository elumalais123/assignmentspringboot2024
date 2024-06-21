package com.cts.employees.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employees.entities.Employee;
import com.cts.employees.services.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> getEmployees() {
		return new ResponseEntity<List<Employee>>(service.fetchEmployees(), HttpStatus.OK);
	}

	@GetMapping("/findbyid/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer empId) {
		return ResponseEntity.ok(service.fetchEmployeeByID(empId));
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmp(@RequestBody @Valid Employee employee) {
		return new ResponseEntity<Employee>(service.createEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> delEmp(@PathVariable Integer empId) {
		return ResponseEntity.ok(service.delEmployeeByID(empId));
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> update(@PathVariable Integer empId, @RequestBody @Valid Employee emp) {
		return new ResponseEntity<Employee>(service.updateEmployee(empId, emp), HttpStatus.ACCEPTED);
	}
}
