package com.manage.dao.domain;

public class ChangeSkdept {

	private String olddept;
	private String newdept;
	private String oldjob;
	private String newjob;
	
	private int id;
	private String sex;
	private String name;//员工姓名
	
	private String depttime;//部门调动日期 
	private String deptreason;//部门调转原因
	private String deptype;//部门调转类型
	
	
	private String jobtime;//岗位调动日期   ——调转日期
	private String time;//岗位调转原因  
	private String type;//岗位调转类型
	
	public String getDeptype() {
		return deptype;
	}
	public void setDeptype(String deptype) {
		this.deptype = deptype;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOlddept() {
		return olddept;
	}
	public void setOlddept(String olddept) {
		this.olddept = olddept;
	}
	public String getNewdept() {
		return newdept;
	}
	public void setNewdept(String newdept) {
		this.newdept = newdept;
	}
	public String getOldjob() {
		return oldjob;
	}
	public void setOldjob(String oldjob) {
		this.oldjob = oldjob;
	}
	public String getNewjob() {
		return newjob;
	}
	public void setNewjob(String newjob) {
		this.newjob = newjob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDepttime() {
		return depttime;
	}
	public void setDepttime(String depttime) {
		this.depttime = depttime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJobtime() {
		return jobtime;
	}
	public void setJobtime(String jobtime) {
		this.jobtime = jobtime;
	}
	public String getDeptreason() {
		return deptreason;
	}
	public void setDeptreason(String deptreason) {
		this.deptreason = deptreason;
	}
	
}
