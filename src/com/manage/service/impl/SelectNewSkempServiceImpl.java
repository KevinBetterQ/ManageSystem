package com.manage.service.impl;

import java.util.List;

import com.manage.dao.SkempDao;
import com.manage.dao.domain.Skemp;
import com.manage.dao.impl.SkempDaoImpl;
import com.manage.service.SelectNewSkempService;



public class SelectNewSkempServiceImpl implements SelectNewSkempService {

	public List<Skemp> getSelectNewSkemp(String time1, String time2, String name) {
		// TODO Auto-generated method stub
		SkempDao skempDao=new SkempDaoImpl();
		return skempDao.getSkempNewStaff(time1, time2,name);
	}

}
