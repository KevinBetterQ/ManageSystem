<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style type="text/css">
<!--
.STYLE3 {font-size: 10; }
-->
</style>
<script language="javascript" type="text/javascript">


</script>
</head>

<body>
<div id="man_zone">
  <form action="<%=basePath %>show/login.jsp" onsubmit="return link();" method="post" enctype="multipart/form-data" name="fom" id="fom"  target="_parent" >
    <div class="MainDiv">
      <table width="97%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">退出系统页面</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="95%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            <tr class="CTitle" >
              <td height="22" colspan="11" align="center" style="font-size:16px"><p>是否退出登陆系统</p>                </td>
            </tr>
            
      </table>
	 
      <div align="center">
        <input type="submit" name="save" value="确定" />
       &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
<input type="button" name="cancel" value="取消" action="<%=basePath %>index.jsp"/>
      </div>
  </form>
</div>
</body>
</html>
