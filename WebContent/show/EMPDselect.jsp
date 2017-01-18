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

  function link(){
  if(document.fom.id.value==""&&document.fom.id2.value==""){
	alert("您必须选择一项！");
	return false;
}
if(document.fom.id.value.length==""||document.fom.id.value.length=='15'||document.fom.id.value.length=='18'&&document.fom.id2.value.length>0){
			}else{
		
		alert("您输入的身份证不正确！");
		return false;
		}
		return true;
}
</script>
</head>

<body>
<div id="man_zone">
  <form id="form1" name="form1" method="post"  action="<%=basePath %>SkempServlet?service=select">
    <div class="MainDiv">
      <table width="97%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">在职人员查询页面</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="99%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            <tr class="CTitle" >
              <td height="22" colspan="16" align="center" style="font-size:16px">查询在职人员信息</td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td colspan="16" align="center"><div align="center">
                <p>请输入您要查询的信息</p>
                <p>员工编号：
                  <input type="text" name="id" />
                </p>
              </div>
                    <div align="center" class="STYLE3">
                      <label></label>
                    </div>
                <div align="center" class="STYLE3">
                      <label></label>
                  </div></td>
            </tr>
          </table></td>
        </tr>
      </table>
      <br />
      <div align="center">
        <input type="submit" name="Submit" value="查询" />
        &nbsp;&nbsp;
        &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" name="Submit2" value="取消" />
      </div>
    </div>
  </form>
</div>
</body>
</html>
