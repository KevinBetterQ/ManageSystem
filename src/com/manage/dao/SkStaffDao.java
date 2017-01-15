package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Skstaff;


public interface SkStaffDao {
	void insertSkStaff(Skstaff skstaff);
	void updateSkStaff(Skstaff skstaff);
	void deleteSkStaff(Skstaff skstaff);
	List<Skstaff> getSkStaffs();
	Skstaff getSkStaffsById(int empno);
}
