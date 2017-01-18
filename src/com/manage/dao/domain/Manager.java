package com.manage.dao.domain;

public class Manager {
	private int id;
	private String  name;
	private String pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
}
