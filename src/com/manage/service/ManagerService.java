package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Manager;




public interface ManagerService {
	void insertManager(Manager manager);
	void updateManager(Manager manager);
	void deleteManager(int id);
	List<Manager>  getManagers(int id);
	Manager getManagerByDeptno(int id);
	Manager loginManager(int id);
}
