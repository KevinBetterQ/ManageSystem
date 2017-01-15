package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Leave;

public interface LeaveDao {
	void insertLeave(Leave leave);
	void updateLeave(Leave leave);
	void deleteLeave(Leave leave);
	List<Leave> getLeaves();
	Leave getLeavesById(int empno);
}
