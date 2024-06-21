package com.cts.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cts.employees.entities.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// custom query methods

	Employee findByEmail(String email);

}