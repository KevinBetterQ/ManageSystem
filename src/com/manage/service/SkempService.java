package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Skemp;

public interface SkempService {
	void insertSkemp(Skemp skemp);
	void updateSkemp(Skemp skemp);
	void deleteSkemp(Skemp skemp);
	List<Skemp> getSkemps(int id);
	Skemp getSkempById(int id);
}
