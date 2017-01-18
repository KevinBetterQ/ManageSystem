<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Manager" %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>管理区域</title>
</head>

<body>
<div id="man_zone">
<form name="fom" id="fom" method="post" action="updatemanager.html">
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21">&nbsp;</td>
			  <td width="538">查看系统管理员信息</td>
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
               <td height="20">
                 </td>
          	   <td align="right">&nbsp;</td>
          	 </tr>
              <tr>
                <td height="40" colspan="2" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td bgcolor="#EEEEEE" height="22" colspan="10" align="center" style="font-size:16px">管理员详细列表</td>
                  </tr>
				 <tr bgcolor="#EEEEEE">
				   <td width="13%" height="30"><div align="center">管理员姓名</div></td>
				   <td width="9%"><div align="center">管理员帐号</div></td>
				   <td width="7%"><div align="center">登录密码</div></td>
				   <td width="11%"><div align="center">确认密码</div></td>
				   <td width="9%"><div align="center">职务</div></td>
				   <td width="9%"><div align="center">联系电话</div></td>
				   <td width="10%"><div align="center">主管领导</div></td>
				   <td width="19%"><div align="center">操作</div></td>
				   </tr>
				  <%List<Manager>  managers=(List<Manager>)request.getAttribute("managers");
if(managers==null)
{
%>
<tr><td colspan="10">没有符合条件的数据</td></tr>
<%}else{ 
	for(Manager manager:managers)
	{
%>
                  <tr bgcolor="#FFFFFF">
                    <td ><div align="center"><%=manager.getName() %></div></td>
                    <td ><div align="center"><%=manager.getId() %></div></td>
					<td>
					  <div align="center">
					  <%=manager.getPass() %>				      </div>				</td>
                    <td><div align="center"> <%=manager.getPass() %></div></td>
                    <td><div align="center"> <%=manager.getExplanation1() %></div></td>
                    <td><div align="center"> <%=manager.getExplanation2() %></div></td>
                    <td><div align="center"> <%=manager.getExplanation3() %></div></td>
                    <td><div align="center"><a href="ManagerServlet?service=modify&id=<%=manager.getId()%>"> 编辑 | </a><a href="ManagerServlet?service=delete&id=<%=manager.getId()%>">删除</a></div></td>
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
