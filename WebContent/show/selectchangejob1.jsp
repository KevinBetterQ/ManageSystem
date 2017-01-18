<%@page import="com.manage.dao.domain.Skjob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.ChangeSkdept"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>岗位调动员工报表</title>
<SCRIPT language="javascript">

function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}
</SCRIPT>
<style type="text/css">
<!--
.STYLE1 {color: #0000FF}
-->
</style>
</head>

<body>
<div id="man_zone">
<form name="fom" id="fom" method="post" action="">
<table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
      
      <tr>
        <td height="40" class="font42"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" class="newfont03">
          <tr class="CTitle" >
            <td height="22" colspan="6" align="right" style="font-size:16px"><div align="center"><span class="STYLE3">部门位调动员工列表 </span></div></td>
             </tr>
          <tr bgcolor="#EEEEEE">
            <td width="128" height="30" align="center">选择</td>
            <td width="128">原岗位名称</td>
            <td width="128">新岗位名称</td>
       
            <td width="128">姓名 </td>
            <td width="128">性别</td>
            <td width="130">调动日期</td>
            <td>调动原因</td>
          </tr>
             <%List<ChangeSkdept>changeSkjobs=(List<ChangeSkdept>)request.getAttribute("changeSkjobs");
                  if(changeSkjobs==null)
                  {
                  %>
                  <tr><td colspan="7">没有符合条件的数据</td></tr>
                  <%}else{ 
                  	for(ChangeSkdept changeSkdjob:changeSkjobs)
                  	{
                   
                  %>
          <tr bgcolor="#FFFFFF">
            <td width="128" height="20"><input type="checkbox" name="delid"/></td>
            <td width="128" ><%=changeSkdjob.getOldjob()%></td>
            <td width="128"><%=changeSkdjob.getNewjob()   %></td>
            <td width="128"><%=changeSkdjob.getName()   %></td>
            <td width="128"><%=changeSkdjob.getSex()   %></td>
            <td width="130"><%=changeSkdjob.getJobtime()   %></td>
            <td><%=changeSkdjob.getTime()   %></td>
          </tr>
           <%}} %>
          
    </table>
        <p>&nbsp;</p></td>
  </tr>
</table>
</form>

</body>
</html>