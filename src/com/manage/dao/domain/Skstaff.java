package com.manage.dao.domain;

import java.sql.Date;

//员工信息与岗位关联表
public class Skstaff {
	private int empno;//员工id
	private int jobid;//岗位id
	private Date time;//转正日期
	private String source;//人才来源
	
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
}
