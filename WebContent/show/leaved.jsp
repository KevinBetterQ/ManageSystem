<%@page import="com.manage.dao.domain.Skemp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.manage.dao.domain.Leave"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>离职员工信息</title>
</head>

<body>
<div id="man_zone">
<form id="form1" name="form1" method="post" action="<%=basePath %>show/leavingse.jsp">

    <table width="698" border="1" bordercolor="#FFFFFF" bgcolor="#FFFFFF">
      <tr>
        <th colspan="3" scope="col"><div align="center">离职员工信息</div></th>
      </tr>
      <tr>
        <td width="113"><div align="center">名称</div></td>
        <td width="287"><div align="center">内容</div></td>
        <td width="276"><div align="center">备注</div></td>
      </tr>
<%Leave leave=(Leave)request.getAttribute("leave");
		if(leave==null)
		{
		%>
		<tr><td colspan="3">没有符合条件的数据</td></tr>
<%}else{ %>
      <tr>
        <td><div align="center">员工号：</div></td>
        <td><%=leave.getEmpno() %></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">姓名：</div></td>
        <td><%=leave.getEmpname() %></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">岗位编号：</div></td>
        <td><%=leave.getJobid() %></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">离职日期：</div></td>
        <td><%=leave.getTime() %></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>离职类型：</td>
        <td><%=leave.getReason() %></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>离职去向：</td>
        <td><%=leave.getPlace() %></td>
        <td>&nbsp;</td>
      </tr>
      
<%} %>
    </table>
    <p>
      <label>
      <input type="submit" name="Submit3" value="返回" />
      </label>
    </p>
    <p>
      <label></label>
      <label></label></p>

</form>
</div>
</body>
</html>
