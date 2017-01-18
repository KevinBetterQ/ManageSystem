package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Department;



public interface DepartmentService {

	void selectDpartment(Department depart);
	void insertDpartment(Department depart);
	void updateDpartment(Department depart);
	void deleteDpartment(int id);
	List<Department> getDepartments();
	Department getDepartmentById(int id);
	List<Department> getDepartmentstaff(int id);
}
