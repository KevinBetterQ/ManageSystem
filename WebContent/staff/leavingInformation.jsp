﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Leave" %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>离职办理</title>
<style type="text/css">
<!--
.STYLE1 {
	font-size: 16px;
	font-weight: bold;
	font-family: "新宋体";
}
-->
</style>
</head>

<body>
<div id="man_zone">
<table width="1014" height="181" border="1" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
  <tr bgcolor="#33CCFF">
    <td colspan="6"><div align="center" class="STYLE1">员工信息 </div></td>
  </tr>
  <tr>
    <td width="91"><div align="center">员工姓名</div></td>
    <td width="128"><div align="center">员工编号</div></td>
    <td width="124"><div align="center">部门名</div></td>
    <td width="138"><div align="center">部门编号</div></td>
    <td width="314"><div align="center">身份证号</div></td>
    <td width="179"><div align="center">操作</div></td>
  </tr>
  
  <%Leave leave=(Leave)request.getAttribute("leave");
if(leave==null)
{
%>
<tr><td colspan="6">没有符合条件的数据</td></tr>
<%}else{ 
%>
<tr>
<td width="91"><div align="center">哈哈</div></td>
<td width="128"><div align="center"><%=leave.getEmpno() %></div></td>
<td width="124"><div align="center">部门</div></td>
<td width="138"><div align="center"><%=leave.getJobid() %></div></td>
<td width="179"><div align="center">0000000</div></td>
<tr>

<%} %>
  
  <!-- <tr>
    <td><div align="center">哈哈</div></td>
    <td><div align="center">123</div></td>
    <td><div align="center">财务部</div></td>
    <td><div align="center">2013</div></td>
    <td><div align="center">123456789</div></td>
    <td><div align="center"><a href="information.html">查询详细信息</a> <a href="leaving.html">离职</a></div></td>
  </tr> -->
  
</table>
<!-- <form id="form1" name="form1" method="post" action="">
  <label>
  <input type="submit" name="Submit" value="上一页" />
  </label>
  <label>
  <input name="textfield" type="text" value="1"  size="3" />
  </label>
  <label>
  <input type="submit" name="Submit2" value="下一页" />
  </label>
</form> -->
</div>
</body>
</html>
