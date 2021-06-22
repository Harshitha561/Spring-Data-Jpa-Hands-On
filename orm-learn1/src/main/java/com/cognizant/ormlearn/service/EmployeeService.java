package com.cognizant.ormlearn.service;

import java.util.List;

import com.cognizant.ormlearn.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int id);
	
	

	void saveEmployee(Employee employee);
	
	List<Employee> findAllPermanentEmployees();
	
	double getAverageSalaryofEmployees();
	
	double getAverageSalaryBasedOnDeptId(int id);
	
	List<Employee> getAllEmployeesUsingNativeQuery(); 
}
