<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Department"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>部门员工查询</title>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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

function link(){
    document.getElementById("fom").action="addrenwu.htm";
   document.getElementById("fom").submit();
}
function link1(){
     location.href="adddept.html";
}
function link2(){
      if (document.fom.delid.onchick==true){
	  alert("您的选择没有可执行的操作！");
	  }else {
	   location.href="multimod.html";
	  }
}

</SCRIPT>

</head>

<body>
<div id="man_zone">
  <form name="fom" id="fom" method="post" action="">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr>
        <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="62" background="../images/nav04.gif"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
                <td width="538">部门员工信息列表</td>
                <td width="144" align="left"><a href="#" onclick="sousuo()"></a></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr class="CTitle" >
                    <td height="22" colspan="12" align="center" style="font-size:16px"> 部 门 员 工 信 息 列 表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
                    <td width="5%" align="center" height="30"><div align="center">序号</div></td>
                    <td width="9%"><div align="center">员工编号</div></td>
                    <td width="11%"><div align="center">员工姓名</div></td>
                    <td width="9%"><div align="center">部门编号</div></td>
                    <td width="17%"><div align="center">部门名称</div></td>
                   <%--<td width="8%"><div align="center">职务</div></td> --%> 
                    <td width="20%"><div align="center">联系电话</div></td>
                    <td width="9%"><div align="center">岗位编号</div></td>
                    <td width="20%"><div align="center">岗位名称</div></td>
                   <%-- <td width="19%"><div align="center">入职日期</div></td>--%>
                    <%--<td width="9%"><div align="center">人数总计</div></td>--%>
                  </tr>
                      <%List<Department> departments = (List<Department>)request.getAttribute("departments");
                  if(departments==null)
                  {
                  %>
                  <tr><td colspan="7">没有符合条件的数据</td></tr>
                  <%}else{ 
                	  int i=1;
                  	for(Department depart:departments)
                  	{
                   
                  %>
                  <tr bgcolor="#FFFFFF">
                    <td height="20"><div align="center"> <%=i %></div></td>
                    <td ><div align="center"> <%=depart.getId()   %></div></td>
                    <td ><div align="center"><%=depart.getName()  %></div></td>
                    <td><div align="center"> <%=depart.getId()  %></div></td>
                    <td><div align="center"> <%=depart.getType() %></div></td>
                     <%--<td><div align="center"> 64275080 </div></td> --%> 
                    <td><div align="center"> <%=depart.getTele()  %> </div></td>
                    <td><div align="center"> <%=depart.getJobid() %></div></td>
                    <td><div align="center"> <%=depart.getJobname() %></div></td>
                    <%--<td><div align="center"> 1997-08-06 </div></td>--%>
                   <%-- <td><div align="center">*</div></td>--%>
                  </tr>
                   <%i++;}} %>
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
                            <td width="49%">共 1 页 | 第 <span class="right-text09">1</span> 页</td>
                            <td width="48%" align="right">&nbsp;</td>
                            <td width="5%">&nbsp;</td>
                          </tr>
                      </table></td>
                    </tr>
                </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>
