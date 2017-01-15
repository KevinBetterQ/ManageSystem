package com.manage.dao.domain;

import java.sql.Date;

public class Leave {
	int empno;//员工编号
	String jobid;//岗位编号
	Date time;//离职时间
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
