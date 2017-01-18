package com.manage.service;

import java.util.List;

import com.manage.dao.domain.Skemp;



public interface SelectNewSkempService {
	List<Skemp> getSelectNewSkemp(String time1,String time2,String name);
}
