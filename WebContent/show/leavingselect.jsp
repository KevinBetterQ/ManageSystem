﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>管理区域</title>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
.STYLE3 {color: #000000}
-->
</style>


<script language='javascript'>                                                                                           
	function yanzheng(){                                                                                                  
	
	                                                                                   
	                                                                     
	 if(document.form1.ygnum.value =='' )           
	 { alert("查询条件不能都为空");   
	        return false;} 
			return true;                                                                   
	                                                                                         
	}                                                                                                                    
	                                                                                                                      
                                                                                                                    
</script>

</head>

<body>
<div id="man_zone">
<form  method="post" name="form1" onsubmit="return yanzheng();"action="<%=basePath %>LeaveServlet?flag=select">    
<div class="MainDiv">
      <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">员工查询</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
              <tr class="CTitle" >
                <td height="22" align="center" style="font-size:16px"><div align="center">员工查询</div></td>
              </tr>
              <tr bgcolor="#EEEEEE">
                <td align="center"><br/>
                  <table width="30%" border="0" align="center">
                    <tr>
                      <td colspan="2"><div align="left"><span class="STYLE3">请输入查询条件：</span></div></td>
                    </tr>
                     <tr>
                      <td><div align="left"><span class="STYLE3">员工编号：</span></div></td>
                      <td><div align="left">
                        <input name="ygnum" type="text" size="15" />
                      </div>                        <div align="left"></div>                      <div align="left"></div></td>
                    </tr>
                    <tr>
                      <td height="38"><div align="left"></div></td>
                      <td><div align="left">
  <input type="submit" name="Submit32" value="查询" />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" name="Submit222" value="取消" />
                      </div></td>
                    </tr>
                  </table>
                <p>&nbsp;</p>                <div align="center">
                  <label></label>
                </div></td>
              </tr>
              
          </table></td>
        </tr>
      </table>
      <span style="position:absolute; left:87px;  
   top:339px; width:910px; height:272px; z-index:1; ">
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0" width="910" height="272" align="middle">
        <param name="allowScriptAccess" value="sameDomain" />
        <param name="allowFullScreen" value="false" />
        <param name="movie" value="1.swf" />
        <param name="quality" value="high" />
        <param name="bgcolor" value="#FFFFFF" />
        <embed src="1.swf" quality="high" bgcolor="#FFFFFF" width="910" height="272" align="middle" allowscriptaccess="sameDomain" allowfullscreen="false" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" /></embed>
      </object>
    </span></div>
  </form>
</div>
</body>
</html>
