﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>管理区域</title>
</head>

<body>
<div id="man_zone">
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"></td>
			  <td width="538">查看员工调转信息</td>
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
               <td height="20">&nbsp;</td>
          	   <td align="right"><input name="Submit2" type="button" class="right-button08" onclick="link();" value="员工调转信息报表"/></td>
          	 </tr>
              <tr>
                <td height="40" colspan="2" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="10" align="center" style="font-size:16px">员工调转的详细信息列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="7%" align="center" height="30"><div align="center">员工编号</div></td>
                    <td width="7%"><div align="center">员工姓名</div></td>
                    <td width="8%"><div align="center">原所在部门</div></td>
					<td width="10%"><div align="center">原所在岗位</div></td>
                    <td width="8%"><div align="center">现在部门</div></td>
					<td width="9%"><div align="center">现在岗位</div></td>
					<td width="9%"><div align="center">调转时间</div></td>
					<td width="10%"><div align="center">调转方式</div></td>
					<td width="13%"><div align="center">调动时间</div></td>
					<td width="19%"><div align="center">备注</div></td>
                  </tr>
                   <%List<ChangeSkdept>changeSkjobs=(List<ChangeSkdept>)request.getAttribute("changeSkjobs");
                  if(changeSkjobs==null)
                  {
                  %>
                  <tr><td colspan="10">没有符合条件的数据</td></tr>
                  <%}else{ 
                  	for(ChangeSkdept changeSkdjob:changeSkjobs)
                  	{
                   
                  %>
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><div align="center">20100092</div></td>
                    <td ><div align="center">张山</div></td>
                    <td ><div align="center"><a href="listmokuaimingxi.htm" onclick=""></a>行政部</div></td>
					<td> <div align="center"><a href="listmokuaimingxi.htm" onclick=""></a>行政总监</div></td>
                    <td><div align="center">商务部</div></td>
                    <td><div align="center">商务总监</div></td>
                    <td><div align="center">2010-3-1</div></td>
                    <td><div align="center">升级</div></td>
                    <td><div align="center">2010-3-1</div></td>
                    <td><div align="center"></div></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><div align="center">
				      20100037</div></td>
                    <td ><div align="center">里斯</div></td>
                    <td ><div align="center"><a href="listmokuaimingxi.htm" onclick=""></a>行政部</div></td>
                    <td><div align="center"><a href="listmokuaimingxi.htm" onclick=""></a>行政总监</div></td>
                    <td><div align="center">商务部</div></td>
                    <td><div align="center">商务总监</div></td>
                    <td><div align="center">2010-3-1</div></td>
                    <td><div align="center">升级</div></td>
                    <td><div align="center">2010-3-1</div></td>
                    <td><div align="center"></div></td>
				  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><div align="center">0000000</div></td>
                    <td ><div align="center"><%=changeSkdjob.getName()   %></div></td>
                    <td ><div align="center">行政部</div></td>
                    <td><div align="center"><%=changeSkdjob.getOldjob()  %></div></td>
                    <td><div align="center">商务部</div></td>
                    <td><div align="center"><%=changeSkdjob.getNewjob()   %></div></td>
                    <td><div align="center"><%=changeSkdjob.getJobtime()   %></div></td>
                    <td><div align="center"><%=changeSkdjob.getType() %></div></td>
                    <td><div align="center">2010-3-1</div></td>
                    <td><div align="center"></div></td>
				  </tr>
				  <%}} %>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">共 <span class="right-text09">5</span> 页 | 第 <span class="right-text09">1</span> 页</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">首页</a> | <a href="#" class="right-font08">上一页</a> | <a href="#" class="right-font08">下一页</a> | <a href="#" class="right-font08">末页</a>] 转至：</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</td>
</tr>
</table>
</form>


 
 
</div>
</body>
</html>
