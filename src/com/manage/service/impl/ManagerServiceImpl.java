package com.manage.service.impl;

import java.util.List;

import com.manage.dao.MangerDao;
import com.manage.dao.domain.Manager;
import com.manage.dao.impl.ManagerDaoImpl;
import com.manage.service.ManagerService;





public class ManagerServiceImpl implements ManagerService{

	@Override
	public void insertManager(Manager manager) {
		// TODO Auto-generated method stub
		MangerDao managerDao=new ManagerDaoImpl();
		managerDao.insertManager(manager);
	}

	@Override
	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		MangerDao managerDao=new ManagerDaoImpl();
		managerDao.updateManager(manager);
	}

	@Override
	public void deleteManager(int id) {
		// TODO Auto-generated method stub
		MangerDao managerDao=new ManagerDaoImpl();
		managerDao.deleteManager(id);
	}



	@Override
	public Manager getManagerByDeptno(int id) {
		// TODO Auto-generated method stub
		MangerDao managerDao=new ManagerDaoImpl();
		return managerDao.getManagerByDeptno(id);
	}

	@Override
	public List<Manager> getManagers(int id) {
		// TODO Auto-generated method stub
		MangerDao mangerDao=new ManagerDaoImpl();
		
		return mangerDao.getManagers(id);
	}

	@Override
	public Manager loginManager(int id) {
		// TODO Auto-generated method stub
		MangerDao managerDao=new ManagerDaoImpl();
		return managerDao.loginManager(id);
	}

}
