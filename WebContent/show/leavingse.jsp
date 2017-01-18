<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>离职管理</title>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
.STYLE3 {color: #000000}
-->
</style>
<script language="javascript">
document.writeln('<div id=meizzDateLayer style="position: absolute; width: 142; height: 166; z-index: 9998; display: none">');
document.writeln('<span id=tmpSelectYearLayer style="z-index: 9999;position: absolute;top: 2; left: 18;display: none"></span>');
document.writeln('<span id=tmpSelectMonthLayer style="z-index: 9999;position: absolute;top: 2; left: 75;display: none"></span>');
document.writeln('<table border=0 cellspacing=1 cellpadding=0 width=142 height=160 bgcolor=#000000 onselectstart="return false">');
document.writeln(' <tr><td width=142 height=23 bgcolor=#FFFFFF><table border=0 cellspacing=1 cellpadding=0 width=140 height=23>');
document.writeln('      <tr align=center><td width=20 align=center bgcolor=#808080 style="font-size:12px;cursor: hand;color: #FFD700" ');
document.writeln('        onclick="meizzPrevM()" title="前一月" Author=meizz><b Author=meizz>&lt;</b>');
document.writeln('        </td><td width=100 align=center style="font-size:12px;cursor:default" Author=meizz>');

document.writeln('        <span Author=meizz id=meizzYearHead onmouseover="style.backgroundColor=\'yellow\'" onmouseout="style.backgroundColor=\'white\'" title="点击这里选择年份" onclick="tmpSelectYearInnerHTML(this.innerText)" style="cursor: hand;"></span>&nbsp;年&nbsp;<span');
document.writeln('         id=meizzMonthHead Author=meizz onmouseover="style.backgroundColor=\'yellow\'" onmouseout="style.backgroundColor=\'white\'" title="点击这里选择月份" onclick="tmpSelectMonthInnerHTML(this.innerText)" style="cursor: hand;"></span>&nbsp;月</td>');

document.writeln('        <td width=20 bgcolor=#808080 align=center style="font-size:12px;cursor: hand;color: #FFD700" ');
document.writeln('         onclick="meizzNextM()" title="后一月" Author=meizz><b Author=meizz>&gt;</b></td></tr>');
document.writeln('    </table></td></tr>');
document.writeln(' <tr><td width=142 height=18 bgcolor=#808080>');
document.writeln('<table border=0 cellspacing=0 cellpadding=0 width=140 height=1 style="cursor:default">');
document.writeln('<tr align=center><td style="font-size:12px;color:#FFFFFF" Author=meizz>日</td>');
document.writeln('<td style="font-size:12px;color:#FFFFFF" Author=meizz class="td1">一</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>二</td>');
document.writeln('<td style="font-size:12px;color:#FFFFFF" Author=meizz>三</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>四</td>');
document.writeln('<td style="font-size:12px;color:#FFFFFF" Author=meizz>五</td><td style="font-size:12px;color:#FFFFFF" Author=meizz>六</td></tr>');
document.writeln('</table></td></tr><!-- Author:F.R.Huang(meizz) http://www.meizz.com/ mail: meizz@hzcnc.com 2002-10-8 -->');
document.writeln(' <tr><td width=142 height=120>');
document.writeln('    <table border=0 cellspacing=1 cellpadding=0 width=140 height=120 bgcolor=#FFFFFF>');
var n=0; for (j=0;j<5;j++){ document.writeln (' <tr align=center>'); for (i=0;i<7;i++){
document.writeln('<td width=20 height=20 id=meizzDay'+n+' style="font-size:12px" Author=meizz onclick=meizzDayClick(this.innerText)></td>');n++;}
document.writeln('</tr>');}
document.writeln('      <tr align=center><td width=20 height=20 style="font-size:12px" id=meizzDay35 Author=meizz ');
document.writeln('         onclick=meizzDayClick(this.innerText)></td>');
document.writeln('        <td width=20 height=20 style="font-size:12px" id=meizzDay36 Author=meizz onclick=meizzDayClick(this.innerText)></td>');
document.writeln('        <td colspan=5 align=right Author=meizz><span onclick=closeLayer() style="font-size:12px;cursor: hand"');
document.writeln('         Author=meizz title="返回（不选择日期）"><u>关闭</u></span>&nbsp;</td></tr>');
document.writeln('    </table></td></tr><tr><td>');
document.writeln('        <table border=0 cellspacing=1 cellpadding=0 width=100% bgcolor=#FFFFFF>');
document.writeln('          <tr><td Author=meizz align=left><input Author=meizz type=button value="<<" title="前一年" onclick="meizzPrevY()" ');
document.writeln('             onfocus="this.blur()" style=" cursor: hand;BACKGROUND-COLOR: #808080;BORDER-BOTTOM: #808080 1px outset; BORDER-LEFT: #808080 1px outset; BORDER-RIGHT: #808080 1px outset; BORDER-TOP: #808080 1px outset; FONT-SIZE: 12px; height: 20px;color: #FFD700; font-weight: bold"><input Author=meizz title="前一月" type=button ');
document.writeln('             value="<" onclick="meizzPrevM()" onfocus="this.blur()" style="cursor: hand;BACKGROUND-COLOR: #808080;BORDER-BOTTOM: #808080 1px outset; BORDER-LEFT: #808080 1px outset; BORDER-RIGHT: #808080 1px outset; BORDER-TOP: #808080 1px outset;font-size: 12px; height: 20px;color: #FFD700; font-weight: bold"></td><td ');
document.writeln('             Author=meizz align=center><input Author=meizz type=button value="重置" onclick="meizzToday()" ');
document.writeln('             onfocus="this.blur()" title="显示当前时间" style="cursor: hand;BACKGROUND-COLOR: #808080;BORDER-BOTTOM: #808080 1px outset; BORDER-LEFT: #808080 1px outset; BORDER-RIGHT: #808080 1px outset; BORDER-TOP: #808080 1px outset;font-size: 12px; height: 20px;color: #FFFFFF; font-weight: bold"></td><td ');
document.writeln('             Author=meizz align=right><input Author=meizz type=button value=">" onclick="meizzNextM()" ');
document.writeln('             onfocus="this.blur()" title="后一月" style="cursor: hand;BACKGROUND-COLOR: #808080;BORDER-BOTTOM: #808080 1px outset; BORDER-LEFT: #808080 1px outset; BORDER-RIGHT: #808080 1px outset; BORDER-TOP: #808080 1px outset;font-size: 12px; height: 20px;color: #FFD700; font-weight: bold"><input ');
document.writeln('             Author=meizz type=button value=" >>" title="后一年" onclick="meizzNextY()"');
document.writeln('             onfocus="this.blur()" style="cursor: hand;BACKGROUND-COLOR: #808080;BORDER-BOTTOM: #808080 1px outset; BORDER-LEFT: #808080 1px outset; BORDER-RIGHT: #808080 1px outset; BORDER-TOP: #808080 1px outset;font-size: 12px; height: 20px;color: #FFD700; font-weight: bold"></td>');
document.writeln('</tr></table></td></tr></table></div>');



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
<form  method="post" name="form1" onsubmit="return yanzheng();"action="<%=basePath %>LeaveServlet?flag=leaved">
    <div class="MainDiv">
      <table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">已离职员工查询</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
              <tr class="CTitle" >
                <td height="22" align="center" style="font-size:16px"><div align="center">已离职员工查询</div></td>
              </tr>
              <tr bgcolor="#EEEEEE">
                <td align="center"><br/>
                  <table width="45%" border="0" align="center">
                    <tr>
                      <td colspan="4"><div align="left"><span class="STYLE3">请输入查询条件：</span></div></td>
                    </tr>
                    <tr>
                      <td width="15%">
                      <div align="left"><span class="STYLE3">员工编号：</span></div>
                     </td>
                      <td colspan="3"><div align="left">
                        <input name="ygnum" type="text" size="15" />
                      </div></td>
                    </tr>
                    
                    <!-- <tr>
                      <td><div align="left"><span class="STYLE3">员工姓名：</span></div></td>
                      <td colspan="3"><div align="left">
                        <input name="ygname" type="text" size="15" />
                      </div></td>
                    </tr> <tr>
                      <td width="14%">
                      <div align="left"><span class="STYLE3">部门名称：</span></div>
                     </td>
                      <td colspan="3"><div align="left">
                        <input name="bmname" type="text" size="15" />
                      </div></td>
                    </tr>
                    <tr>
                      <td><div align="left"><span class="STYLE3">岗位名称：</span></div></td>
                      <td colspan="3"><div align="left">
                        <input name="gwname" type="text" size="15" />
                      </div></td>
                    </tr>
					 <tr>
                      <td width="14%">
                      <div align="left"><span class="STYLE3">离职类型：</span></div>
                     </td>
                      <td colspan="3"><div align="left">
                        <select name="lztype">
                          <option value="0">请输入离职类型</option>
                          <option value="主动辞职">主动辞职</option>
                          <option value="辞退">辞退</option>
                          <option value="退休">退休</option>
                          <option value="开除">开除</option>
                          <option value="试用期未通过">试用期未通过</option>
                        </select>
                      </div></td>
                    </tr> -->
                  
                    
                    
                    <tr>
                      <td height="53"><div align="left"></div></td>
                      <td colspan="3"><div align="left">
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
      <span style="position:absolute; left:65px;  
   top:406px; width:910px; height:202px; z-index:1; ">
      <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0" width="910" height="200" align="middle">
        <param name="allowScriptAccess" value="sameDomain" />
        <param name="allowFullScreen" value="false" />
        <param name="movie" value="11.swf" />
        <param name="quality" value="high" />
        <param name="bgcolor" value="#FFFFFF" />
        <embed src="11.swf" quality="high" bgcolor="#FFFFFF" width="910" height="200" align="middle" allowscriptaccess="sameDomain" allowfullscreen="false" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/go/getflashplayer_cn" /></embed>
        </embed>
      </object>
    </span></div>
  </form>
</div>
</body>
</html>
