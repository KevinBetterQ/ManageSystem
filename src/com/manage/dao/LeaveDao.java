package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Leave;
import com.manage.dao.domain.Skemp;

public interface LeaveDao {
	void insertLeave(Leave leave);
	void updateLeave(Leave leave);
	void deleteLeave(Leave leave);
	List<Leave> getLeaves();
	Leave getLeavesById(int empno);
	List<Leave> getLeavesByTime(String time1,String time2);
}
