package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Skjob;


public interface SkjobService {

	void selectSkjob(Skjob skjob);
	void insertSkjob(Skjob skjob);
	void updateSkjob(Skjob skjob);
	void deleteSkjob(int id);
	List<Skjob> getSkjobs();
	List<Skjob> getSkjobstaff(int id);
	Skjob getSkjobById(int id);
}
