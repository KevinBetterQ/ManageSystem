<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Leave"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>离职员工报表</title>
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
.STYLE3 {color: #0000FF}
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
        <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" class="newfont03">
          <tr class="CTitle" >
            <td height="22" colspan="7" align="right" style="font-size:16px"><div align="center"><span class="STYLE4">离职员工列表</span></div></td>
             </tr>
          <tr bgcolor="#EEEEEE">
            <td width="4%" align="center" height="30">选择</td>
            <td width="10%">员工编号</td>
            <td width="10%">姓名 </td>
            <td width="10%">岗位编号</td>
            <td width="10%">离职去向</td>
            <td width="12%">离职日期</td>
            <td width="12%">离职原因</td>
          </tr>
           <%List<Leave> leaves=(List<Leave>)request.getAttribute("leaves");
                  if(leaves==null)
                  {
                  %>
                  <tr><td colspan="6">没有符合条件的数据</td></tr>
                  <%}else{ 
                  	for(Leave leave:leaves)
                  	{
                   
                  %>
          <tr bgcolor="#FFFFFF">
            <td height="20"><input type="checkbox" name="delid"/></td>
            <td><%=leave.getEmpno()   %></td>
            <td><%=leave.getEmpname()  %></td>
            <td><%=leave.getJobid()   %></td>
            <td><%=leave.getPlace()   %></td>
            <td><%=leave.getTime()  %></td>
            <td><%=leave.getReason()  %></td>
          </tr>
          <%}} %>
         
        </table></td>
      </tr>
    </table>
        <p>&nbsp;</p></td>
  </tr>
</table>
</form>

</body>
</html>
