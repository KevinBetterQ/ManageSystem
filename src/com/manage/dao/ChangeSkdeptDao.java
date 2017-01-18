package com.manage.dao;

import java.util.List;

import com.manage.dao.domain.ChangeSkdept;


public interface ChangeSkdeptDao {

	List<ChangeSkdept> getChangeSkdepts(String time1,String time2);
	List<ChangeSkdept> getChangeSkjobs(String time1,String time2);
	List<ChangeSkdept> getChangeSkemp(int id);
	
	void insertChange(ChangeSkdept changeSkdept);
	//void updateChange(ChangeSkdept changeSkdept);
	
}
