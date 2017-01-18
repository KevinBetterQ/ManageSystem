package com.manage.service.impl;

import java.util.List;

import com.manage.dao.ChangeSkdeptDao;
import com.manage.dao.domain.ChangeSkdept;
import com.manage.dao.impl.ChangeSkdeptDaoImpl;
import com.manage.service.SelectChangeSkeptService;



public class SelectChangeSkeptServiceImpl implements SelectChangeSkeptService{

	@Override
	public List<ChangeSkdept> getChangeSkdept(String time1, String time2) {
		// TODO Auto-generated method stub
		ChangeSkdeptDao changeSkdeptDao=new ChangeSkdeptDaoImpl();
		return changeSkdeptDao.getChangeSkdepts(time1, time2);
	}

	@Override
	public List<ChangeSkdept> getChangeSkjob(String time1, String time2) {
		// TODO Auto-generated method stub
		ChangeSkdeptDao changeSkdeptDao=new ChangeSkdeptDaoImpl();
		
		return changeSkdeptDao.getChangeSkjobs(time1, time2);
	}
	

}
