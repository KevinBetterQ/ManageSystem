package com.manage.service;

import java.util.List;

import com.manage.dao.domain.ChangeSkdept;



public interface SelectChangeSkeptService {
	List<ChangeSkdept> getChangeSkdept(String time1,String time2);
	List<ChangeSkdept> getChangeSkjob(String time1,String time2);
}
