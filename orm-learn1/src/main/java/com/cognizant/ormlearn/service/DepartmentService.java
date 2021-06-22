package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Department;

public interface DepartmentService {

	Department getDepartmentById(int id);

	void saveDepartment(Department department);
}