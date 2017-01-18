package com.manage.service.impl;

import java.util.List;

import com.manage.dao.SkjobDao;
import com.manage.dao.domain.Skjob;
import com.manage.dao.impl.SkjobDaoImpl;
import com.manage.service.SkjobService;



public class SkjobServiceImpl implements SkjobService{

	@Override
	public void selectSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();
		skjobDao.insertSkjob(skjob);
	}

	@Override
	public void updateSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();
		skjobDao.updateSkjob(skjob);
	}

	@Override
	public void deleteSkjob(int id) {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();
		skjobDao.deleteSkjob(id);
	}

	@Override
	public List<Skjob> getSkjobs() {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();
		return skjobDao.getSkjobs();
	}

	@Override
	public Skjob getSkjobById(int id) {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();
		return skjobDao.getSkjobById(id);
	}

	@Override
	public List<Skjob> getSkjobstaff(int id) {
		// TODO Auto-generated method stub
		SkjobDao skjobDao=new SkjobDaoImpl();	
		return skjobDao.getSkjobstaff(id);
	}
	
}
