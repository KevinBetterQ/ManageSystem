package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.Skjob;

public interface SkjobDao {

	void selectSkjob(Skjob skjob);
	void insertSkjob(Skjob skjob);
	void updateSkjob(Skjob skjob);
	void deleteSkjob(int id);
	List<Skjob> getSkjobs();
	Skjob getSkjobById(int id);
}
