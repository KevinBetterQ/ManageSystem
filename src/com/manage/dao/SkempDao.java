package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Skemp;

public interface SkempDao {
	void insertSkemp(Skemp skemp);
	void updateSkemp(Skemp skemp);
	void deleteSkemp(Skemp skemp);
	List<Skemp> getSkemps();
	Skemp getSkempById(int id);
}
