<%@page import="com.manage.dao.domain.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

       
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>部门管理</title>
<SCRIPT language=JavaScript>


function link1(){
   if(document.fom.id.value==""){
    	alert("您没有输入部门编号");
		return false;
		
   }
   if(document.fom.name.value==""){
   	alert("您没有输入部门名称");
	return false;
   }
    for(var i=0;i< fom.id.value.length;i++){
			var ch = fom.id.value.charAt(i);
			if(ch<"0" || ch>"9"){
				alert("部门编号为数字");
				return false;
			}
			}
   return true;
   }

</SCRIPT>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
</head>
<% Department department=(Department)request.getAttribute("department"); %>
<body>
<div id="man_zone">
<form name="fom" id="fom" onsubmit="return link1();"
action="<%=basePath %>DepartmentServlet?service=update" method="post">>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" >
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"></td>
			  <td width="538"><strong>添加部门</strong></td>
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
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="9" align="center" style="font-size:16px"> 添 加 部 门 </td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="8%" height="30"><div align="center">部门编号<span class="STYLE1">*</span></div></td>
                    <td width="11%"><div align="center">部门名称<span class="STYLE1">*</span></div></td>
					<td width="9%"><div align="center">类型</div></td>
                    <td width="12%"><div align="center">电话</div></td>
					<td width="12%"><div align="center">传真</div></td>
					<td width="15%"><div align="center">描述</div></td>
			    <%--<td width="10%"><div align="center">上级部门</div></td> --%>
					<td width="13%"><div align="center">成立日期</div></td>
					<td width="20%"><div align="center">操作</div></td>
                  </tr>
                
                  <tr bgcolor="#FFFFFF">
				    <td height="20" ><div align="center">
                      <label>
                      <input name="id" value="<%=department.getId() %>"type="text" size="10" />
                      </label>
                    </div></td>
                    <td ><div align="center">
                      <label>
                      <input name="name" value="<%=department.getName() %>" type="text" size="12" />
                      </label>
                    </div></td>
					<td>
					  <div align="center">
					    <label>
					    <select name="type">
					      <option value="公司">公司</option>
					      <option value="部门">部门</option>
					      </select>
					    </label>
					</div></td>
                    <td><div align="center">
                      <label>
                      <input type="text" name="tele" value="<%=department.getTele() %>" size="12" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="fax" value="<%=department.getFax()  %>" type="text" size="12" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="discrip" value="<%=department.getDiscrip() %>" type="text" size="14" />
                      </label>
                    </div></td>
                    <td><div align="center">
                      <label>
                      <input name="createtime" value="<%=department.getCreatetime() %>" type="text" size="18" />
                      </label>
                    </div></td>
                    <%--<td><div align="center">
                      <label>
                      <input name="textfield8" type="text" size="16" />
                      </label>
                    </div></td> --%>
                    <td><div align="center">
                      <label>
                      <input name="Submit" type="submit" value="保存"  /> 
                      </label>
                      <label>
                      <input name="reset" type="reset" value="重置" />
                      </label>
                    </div>
		   </td>
                  </tr>
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
</table>
</td>
</tr>
</table>
</form>


 
 
</div>
</body>
</html>
