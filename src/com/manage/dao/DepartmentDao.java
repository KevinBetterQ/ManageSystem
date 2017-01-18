package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Department;

public interface DepartmentDao {
	List<Department> selectDepartment();
	void insertDepartment(Department depart);
	void updateDepartment(Department depart);
	void deleteDepartment(int id);
	List<Department> getDepartments();
	List<Department> getDepartmentstaff(int id);
	Department getDepartmentById(int id);

}
