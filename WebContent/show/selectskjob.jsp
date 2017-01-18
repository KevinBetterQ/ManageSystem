<%@page import="com.manage.dao.domain.Skjob"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Department"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>岗位管理</title>
<SCRIPT language=JavaScript>

function link1(){
     alert("该岗位下有员工，不能删除！");
}
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			  <td width="538">查看岗位信息</td>
			  <td width="144" align="left"><a href="#" onclick="sousuo()"></a></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 
              <tr>
                <td height="40" colspan="2" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td  bgcolor="#EEEEFF" height="22" colspan="10" align="center" style="font-size:16px">岗位详细列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="11%" align="center" height="30"><div align="center">选择</div></td>
                    <td width="13%"><div align="center">岗位编号</div></td>
                    <td width="11%"><div align="center">岗位名称</div></td>
					<td width="12%"><div align="center">类型</div></td>
                    <td width="16%"><div align="center">岗位编制</div></td>
					<td width="16%"><div align="center">隶属部门</div></td>
				<%--<td width="13%"><div align="center">描述</div></td>--%>
				<%--<td width="10%"><div align="center">上级部门</div></td> --%>
				<%--<td width="13%"><div align="center">成立日期</div></td>--%>
					<td width="22%"><div align="center">操作</div></td>
                  </tr>
                  <%List<Skjob>skjobs=(List<Skjob>)request.getAttribute("skjobs");
                  if(skjobs==null)
                  {
                  %>
                  <tr><td colspan="7">没有符合条件的数据</td></tr>
                  <%}else{ 
                  	for(Skjob skjob:skjobs)
                  	{
                   
                  %>
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><div align="center">
				      <input type="checkbox" name="delid"/>
				      </div></td>
                    <td ><div align="center"><%=skjob.getId()   %></div></td>
                    <td ><div align="center"><%=skjob.getName() %></div></td>
					<td ><div align="center"><%=skjob.getType() %></div></td>
                    <td><div align="center"><%=skjob.getLimit()  %></div></td>
                    <td><div align="center"><%=skjob.getDeptno()  %></div></td>
                <%--<td><div align="center"><%=skjob.getDiscrip() %></div></td>--%>
                <%--<td><div align="center"><%=skjob.getCreatetime() %></div></td>--%>
                <%--<td><div align="center">1997-08-06</div></td>--%>
                    <td><div align="center"> 
                    <a href="SkjobServlet?service=modify&id=<%=skjob.getId() %>">修改 </a>
                   |<a href="SkjobServlet?service=delete&id=<%=skjob.getId()  %>" onclick="link1();"> 删除 </a>
                   |<a href="SkjobServlet?service=select&id=<%=skjob.getId() %>"> 查询岗位下员工</a></div></td>
                  </tr>
                  <%}} %>
                  
				  
                
            </table></td>
        </tr>
      </table>
      </td>
  </tr>
</table>
</td>
</tr>
</table>
</form>


 
 
</div>
</body>
</html>

