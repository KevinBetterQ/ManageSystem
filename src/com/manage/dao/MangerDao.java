package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Manager;

public interface MangerDao {
	void insertManager(Manager manager);
	void updateManager(Manager manager);
	void deleteManager(int id);
	List<Manager>  getManagers(int id);
	Manager getManagerByDeptno(int id);
	Manager loginManager(int id);
}
