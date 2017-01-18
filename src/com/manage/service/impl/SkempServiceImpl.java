package com.manage.service.impl;

import java.util.List;

import com.manage.dao.SkempDao;
import com.manage.dao.domain.Skemp;
import com.manage.dao.impl.SkempDaoImpl;
import com.manage.service.SkempService;

public class SkempServiceImpl implements SkempService{

	@Override
	public void insertSkemp(Skemp skemp) {
		SkempDao skempDao = new SkempDaoImpl();
		skempDao.insertSkemp(skemp);
		
	}

	@Override
	public void updateSkemp(Skemp skemp) {
		SkempDao skempDao = new SkempDaoImpl();
		skempDao.updateSkemp(skemp);
		
	}

	@Override
	public void deleteSkemp(Skemp skemp) {
		SkempDao skempDao = new SkempDaoImpl();
		skempDao.deleteSkemp(skemp);
	}

	@Override
	public List<Skemp> getSkemps(int id) {
		SkempDao skempDao = new SkempDaoImpl();
		return skempDao.getSkemps(id);
	}

	@Override
	public Skemp getSkempById(int id) {
		SkempDao skempDao = new SkempDaoImpl();
		return skempDao.getSkempById(id);
	}

}
