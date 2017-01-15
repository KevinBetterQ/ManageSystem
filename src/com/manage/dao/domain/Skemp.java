package com.manage.dao.domain;

import java.sql.Date;
import java.text.spi.DateFormatProvider;

//员工信息
public class Skemp {
	private int id;
	private String name;
	private String sex;
	private Date bir;
	private String idcard;//身份证号
	private Date toworktime;//参加工作时间
	private String zzmm;//政治面貌
	private String national;//民族
	private String native_m;//籍贯
	private String tele;//电话
	private String mail;//
	private String height;
	private String bloodtype;//血型
	private String birthplace;//出生地
	private String hkplace;//户口所在地
	private String xl;//最高学历
	private String degree;//最高学位
	private String graduateschool;//毕业院校
	private String professional;//专业
	private Date graduatetime;//毕业时间
	private int dpid;
	private int jobid;
	private String dpname;
	private String jobname;
	
	
	public int getDpid() {
		return dpid;
	}
	public void setDpid(int dpid) {
		this.dpid = dpid;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String getDpname() {
		return dpname;
	}
	public void setDpname(String dpname) {
		this.dpname = dpname;
	}
	public String getJobname() {
		return jobname;
	}
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBir() {
		return bir;
	}
	public void setBir(Date bir) {
		this.bir = bir;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Date getToworktime() {
		return toworktime;
	}
	public void setToworktime(Date toworktime) {
		this.toworktime = toworktime;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getNative_m() {
		return native_m;
	}
	public void setNative_m(String native_m) {
		this.native_m = native_m;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getHkplace() {
		return hkplace;
	}
	public void setHkplace(String hkplace) {
		this.hkplace = hkplace;
	}
	public String getXl() {
		return xl;
	}
	public void setXl(String xl) {
		this.xl = xl;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGraduateschool() {
		return graduateschool;
	}
	public void setGraduateschool(String graduateschool) {
		this.graduateschool = graduateschool;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	public Date getGraduatetime() {
		return graduatetime;
	}
	public void setGraduatetime(Date graduatetime) {
		this.graduatetime = graduatetime;
	}
	
	
	
}
