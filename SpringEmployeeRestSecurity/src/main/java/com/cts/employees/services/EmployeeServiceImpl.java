package com.cts.employees.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.employees.entities.Employee;
import com.cts.employees.exceptions.EmployeeNotFoundException;
import com.cts.employees.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> fetchEmployees() {
//		System.out.println(employeeRepository.getClass().getSimpleName());
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee fetchEmployeeByID(Integer empId) throws EmployeeNotFoundException {
		return employeeRepository.findById(empId)
				.orElseThrow(() -> new EmployeeNotFoundException("No Employee Found With ID " + empId));
	}

	@Override
	public String delEmployeeByID(Integer empId) throws EmployeeNotFoundException {
		Employee employee = fetchEmployeeByID(empId);

		employeeRepository.delete(employee);

		return "Employee With ID " + empId + " Deleted Successfully!";
	}

	@Override
	public Employee updateEmployee(Integer empId, Employee updateEmp) throws EmployeeNotFoundException {

		Employee oldEmployee = fetchEmployeeByID(empId);

		oldEmployee.setEmail(updateEmp.getEmail());
		oldEmployee.setEname(updateEmp.getEname());
		oldEmployee.setMobile(updateEmp.getMobile());

		employeeRepository.save(oldEmployee);

		return oldEmployee;
	}
}
