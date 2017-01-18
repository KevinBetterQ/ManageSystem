package com.manage.service.impl;

import java.util.List;

import com.manage.dao.DepartmentDao;
import com.manage.dao.domain.Department;
import com.manage.dao.impl.DepartmentDaoImpl;
import com.manage.service.DepartmentService;


public class DepartmentServiceImpl implements DepartmentService{

	@Override
	public void selectDpartment(Department depart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertDpartment(Department depart) {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		departmentDao.insertDepartment(depart);
	}

	@Override
	public void updateDpartment(Department depart) {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		departmentDao.updateDepartment(depart);
	}

	@Override
	public void deleteDpartment(int id) {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		departmentDao.deleteDepartment(id);
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		
		return departmentDao.getDepartments();
		
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		return departmentDao.getDepartmentById(id);
	}

	@Override
	public List<Department> getDepartmentstaff(int id) {
		// TODO Auto-generated method stub
		DepartmentDao departmentDao =new DepartmentDaoImpl();
		return departmentDao.getDepartmentstaff(id);
	}

}
