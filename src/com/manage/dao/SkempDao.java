package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Skemp;

public interface SkempDao {
	void insertSkemp(Skemp skemp);
	void updateSkemp(Skemp skemp);
	void deleteSkemp(Skemp skemp);
	List<Skemp> getSkemps(int id);
	Skemp getSkempById(int id);
	List<Skemp> getSkempNewStaff(String time1,String time2,String name);
	void updateSkChange(Skemp skempChange);
}
