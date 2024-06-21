package com.cts.employees.services;

import java.util.List;

import com.cts.employees.entities.Employee;
import com.cts.employees.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

	List<Employee> fetchEmployees();

	Employee createEmployee(Employee employee);

	Employee fetchEmployeeByID(Integer empId) throws EmployeeNotFoundException;

	String delEmployeeByID(Integer empId) throws EmployeeNotFoundException;

	Employee updateEmployee(Integer empId, Employee updateEmp) throws EmployeeNotFoundException;
}
