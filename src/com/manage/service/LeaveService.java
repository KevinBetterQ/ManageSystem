package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Leave;

public interface LeaveService {
	void insertLeave(Leave leave);
	void updateLeave(Leave leave);
	void deleteLeave(Leave leave);
	List<Leave> getLeaves();
	Leave getLeavesById(int empno);
}
