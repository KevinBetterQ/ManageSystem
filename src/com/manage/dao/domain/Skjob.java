package com.manage.dao.domain;

public class Skjob {

	private int id;//岗位编号
	private String name;//岗位名称
	private String type;//岗位类型
	private int limit;//岗位编制
	private int deptno;//隶属部门
	private int jobid;//岗位下查询员工时代表岗位编号，
	private String jbname;//岗位下查询员工时代表岗位名称，而name变为员工名称
	
	private String explanation1;
	private String explanation2;
	private String explanation3;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getExplanation1() {
		return explanation1;
	}
	public void setExplanation1(String explanation1) {
		this.explanation1 = explanation1;
	}
	public String getExplanation2() {
		return explanation2;
	}
	public void setExplanation2(String explanation2) {
		this.explanation2 = explanation2;
	}
	public String getExplanation3() {
		return explanation3;
	}
	public void setExplanation3(String explanation3) {
		this.explanation3 = explanation3;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getJbname() {
		return jbname;
	}
	public void setJbname(String jbname) {
		this.jbname = jbname;
	}
	
	
	
}
