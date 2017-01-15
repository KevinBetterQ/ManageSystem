package com.manage.service.impl;

import java.util.List;

import com.manage.dao.LeaveDao;
import com.manage.dao.domain.Leave;
import com.manage.dao.impl.LeaveDaoImpl;
import com.manage.service.LeaveService;

public class LeaveServiceImpl implements LeaveService{

	@Override
	public void insertLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Leave> getLeaves() {
		LeaveDao leaveDao = new LeaveDaoImpl();
		return leaveDao.getLeaves();
	}

	@Override
	public Leave getLeavesById(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

}
