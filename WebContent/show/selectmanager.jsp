﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>管理员查询</title>
<script language="javascript">

//---
function cancle(){
location.href("test.html");
return false;
}
//-----
function yanzheng(){
var bh=document.form1.bianhao.value;
var xm=document.form1.xingming.value;
var bm=document.form1.bumen.value;
                                                                                                  
if(bh==''&&xm==''&&bm==''){                                                                                                                            
alert("请填写查询条件");
return false;  }                                                                                                                         
}
</script>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(../images/bg.gif);
}
.STYLE4 {color: #666}
.STYLE5 {font-size: 16px}
</style>
</head>

<body>
<div id="man_zone">
<form id="form1" name="form1" method="post"  action="<%=basePath %>ManagerServlet?service=select">
  管理员查询
  </label>
  <label></label>
  <label></label>
  <label></label>
  <label></label>
  <label><br />
  </label>
  <table width="100%" border="0">
    <tr>
     <td height="22" align="center" style="font-size:16px"><div align="center">管理员查询
         </label>
     </div>       </td></td>
    </tr>
  </table>
  <label><br />
  </label>
    <table width="45%" border="0" align="center">
    <tr>
      <td colspan="2"><span class="STYLE4">请输入查询条件</span></td>
      </tr>
    <tr>
      <td width="43%"><label><span class="STYLE4">管理员编号：      </span></label></td>
      <td width="57%"><input type="text" name="id" /></td>
      </tr>
    <tr>
      <td><input type="submit" name="buttion" value="查询" />&nbsp;
        <input type="submit" name="Submit2" value="取消"  onclick=" return cancle()" />     </td>
      <td>&nbsp;</td>
      </tr>
  </table>

</form>
</div>
</body>
</html>
