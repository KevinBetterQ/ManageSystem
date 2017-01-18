
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Skemp" %>
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
.STYLE3 {font-size: 10; }
.STYLE4 {color: #FF0000}
-->
</style>

<script language="javascript" type="text/javascript">
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


var outObject;
function setday(tt,obj) //主调函数
{
if (arguments.length > 2){alert("对不起！传入本控件的参数太多！");return;}
if (arguments.length == 0){alert("对不起！您没有传回本控件任何参数！");return;}
var dads = document.all.meizzDateLayer.style;var th = tt;
var ttop = tt.offsetTop;     //TT控件的定位点高
var thei = tt.clientHeight; //TT控件本身的高
var tleft = tt.offsetLeft;    //TT控件的定位点宽
var ttyp = tt.type;          //TT控件的类型
while (tt = tt.offsetParent){ttop+=tt.offsetTop; tleft+=tt.offsetLeft;}
dads.top = (ttyp=="image")? ttop+thei : ttop+thei+6;
dads.left = tleft;
outObject = (arguments.length == 1) ? th : obj;
dads.display = '';
event.returnValue=false;
}

var MonHead = new Array(12);         //定义阳历中每个月的最大天数
    MonHead[0] = 31; MonHead[1] = 28; MonHead[2] = 31; MonHead[3] = 30; MonHead[4] = 31; MonHead[5] = 30;
    MonHead[6] = 31; MonHead[7] = 31; MonHead[8] = 30; MonHead[9] = 31; MonHead[10] = 30; MonHead[11] = 31;

var meizzTheYear=new Date().getFullYear(); //定义年的变量的初始值
var meizzTheMonth=new Date().getMonth()+1; //定义月的变量的初始值
var meizzWDay=new Array(37);               //定义写日期的数组

function document.onclick() //任意点击时关闭该控件
{ 
with(window.event.srcElement)
{ if (tagName != "INPUT" && getAttribute("Author")==null)
    document.all.meizzDateLayer.style.display="none";
}
}

function meizzWriteHead(yy,mm) //往 head 中写入当前的年与月
{ document.all.meizzYearHead.innerText = yy;
    document.all.meizzMonthHead.innerText = mm;
}

function tmpSelectYearInnerHTML(strYear) //年份的下拉框
{
if (strYear.match(/\D/)!=null){alert("年份输入参数不是数字！");return;}
var m = (strYear) ? strYear : new Date().getFullYear();
if (m < 1000 || m > 9999) {alert("年份值不在 1000 到 9999 之间！");return;}
var n = m - 10;
if (n < 1000) n = 1000;
if (n + 26 > 9999) n = 9974;
var s = "<select Author=meizz name=tmpSelectYear style='font-size: 12px' "
     s += "onblur='document.all.tmpSelectYearLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectYearLayer.style.display=\"none\";"
     s += "meizzTheYear = this.value; meizzSetDay(meizzTheYear,meizzTheMonth)'>\r\n";
var selectInnerHTML = s;
for (var i = n; i < n + 26; i++)
{
    if (i == m)
       {selectInnerHTML += "<option value='" + i + "' selected>" + i + "年" + "</option>\r\n";}
    else {selectInnerHTML += "<option value='" + i + "'>" + i + "年" + "</option>\r\n";}
}
selectInnerHTML += "</select>";
document.all.tmpSelectYearLayer.style.display="";
document.all.tmpSelectYearLayer.innerHTML = selectInnerHTML;
document.all.tmpSelectYear.focus();
}

function tmpSelectMonthInnerHTML(strMonth) //月份的下拉框
{
if (strMonth.match(/\D/)!=null){alert("月份输入参数不是数字！");return;}
var m = (strMonth) ? strMonth : new Date().getMonth() + 1;
var s = "<select Author=meizz name=tmpSelectMonth style='font-size: 12px' "
     s += "onblur='document.all.tmpSelectMonthLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectMonthLayer.style.display=\"none\";"
     s += "meizzTheMonth = this.value; meizzSetDay(meizzTheYear,meizzTheMonth)'>\r\n";
var selectInnerHTML = s;
for (var i = 1; i < 13; i++)
{
    if (i == m)
       {selectInnerHTML += "<option value='"+i+"' selected>"+i+"月"+"</option>\r\n";}
    else {selectInnerHTML += "<option value='"+i+"'>"+i+"月"+"</option>\r\n";}
}
selectInnerHTML += "</select>";
document.all.tmpSelectMonthLayer.style.display="";
document.all.tmpSelectMonthLayer.innerHTML = selectInnerHTML;
document.all.tmpSelectMonth.focus();
}

function closeLayer()               //这个层的关闭
{
    document.all.meizzDateLayer.style.display="none";
}

function document.onkeydown()
{
    if (window.event.keyCode==27)document.all.meizzDateLayer.style.display="none";
}

function IsPinYear(year)            //判断是否闰平年
{
    if (0==year%4&&((year%100!=0)||(year%400==0))) return true;else return false;
}

function GetMonthCount(year,month) //闰年二月为29天
{
    var c=MonHead[month-1];if((month==2)&&IsPinYear(year)) c++;return c;
}

function GetDOW(day,month,year)     //求某天的星期几
{
    var dt=new Date(year,month-1,day).getDay()/7; return dt;
}

function meizzPrevY() //往前翻 Year
{
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear--;}
    else{alert("年份超出范围（1000-9999）！");}
    meizzSetDay(meizzTheYear,meizzTheMonth);
}
function meizzNextY() //往后翻 Year
{
    if(meizzTheYear > 999 && meizzTheYear <10000){meizzTheYear++;}
    else{alert("年份超出范围（1000-9999）！");}
    meizzSetDay(meizzTheYear,meizzTheMonth);
}
function meizzToday() //Today Button
{
    meizzTheYear = new Date().getFullYear();
    meizzTheMonth = new Date().getMonth()+1;
    meizzSetDay(meizzTheYear,meizzTheMonth);
}
function meizzPrevM() //往前翻月份
{
    if(meizzTheMonth>1){meizzTheMonth--}else{meizzTheYear--;meizzTheMonth=12;}
    meizzSetDay(meizzTheYear,meizzTheMonth);
}
function meizzNextM() //往后翻月份
{
    if(meizzTheMonth==12){meizzTheYear++;meizzTheMonth=1}else{meizzTheMonth++}
    meizzSetDay(meizzTheYear,meizzTheMonth);
}

function meizzSetDay(yy,mm)   //主要的写程序**********
{
meizzWriteHead(yy,mm);
for (var i = 0; i < 37; i++){meizzWDay[i]=""}; //将显示框的内容全部清空
var day1 = 1,firstday = new Date(yy,mm-1,1).getDay(); //某月第一天的星期几
for (var i = firstday; day1 < GetMonthCount(yy,mm)+1; i++){meizzWDay[i]=day1;day1++;}
for (var i = 0; i < 37; i++)
{ var da = eval("document.all.meizzDay"+i)     //书写新的一个月的日期星期排列
    if (meizzWDay[i]!="")
      { da.innerHTML = "<b>" + meizzWDay[i] + "</b>";
        da.style.backgroundColor = (yy == new Date().getFullYear() &&
        mm == new Date().getMonth()+1 && meizzWDay[i] == new Date().getDate()) ? "#FFD700" : "#73a6de";
        da.style.cursor="hand"
      }
    else{da.innerHTML="";da.style.backgroundColor="";da.style.cursor="default"}
}
}
function meizzDayClick(n) //点击显示框选取日期，主输入函数*************
{
var yy = meizzTheYear;
var mm = meizzTheMonth;
if (mm < 10){mm = "0" + mm;}
if (outObject)
{
    if (!n) {outObject.value=""; return;}
    if ( n < 10){n = "0" + n;}
    outObject.value= yy + "-" + mm + "-" + n ; //注：在这里你可以输出改成你想要的格式
    closeLayer(); 
}
else {closeLayer(); alert("您所要输出的控件对象并不存在！");}
}
meizzSetDay(meizzTheYear,meizzTheMonth);
//---
function cancle(){
location.href("test.html");
return false;
}
///----
function isDate(date){   
    var regu = "^[0-9]{4}-([0-1]?)[0-9]{1}-([0-3]?)[0-9]{1}$";   
    var re   = new RegExp(regu);   
    if (date.search(re) != -1)   
        return true;   
    else  
        return false;   
}    
//-----
function yanzheng(){
var bh=document.form1.bianhao.value;
var xm=document.form1.xingming.value;
var bm=document.form1.bumen.value;
var sj=document.form1.time.value;                                                                                                     
if(bh==''&&xm==''&&bm==''&&sj==''){                                                                                                                            
alert("请填写查询条件");
return false;  }  

//-----验证时间格式  YYYY-MM-DD   
  
var startDate=document.getElementById("time").value;   
 if(!isDate(startDate)&&startDate!=''){           
alert("请输入正确的转正日期格式!如:(YYYY-MM-DD)2008-01-01");   
 return false;   
 }    
		                                                                                                                         
}


function link(){                                                                                                  
	
	 
	 if(document.fom.odno.value =='')  
	          { alert("原部门编号不能为空！");   
	        return false;} 
			
			 for(var i=0;i< fom.odno.value.length;i++){
			var ch = fom.odno.value.charAt(i);
			if(ch<"0" || ch>"9"){
				alert("部门编号为数字");
				return false;
			}
			}
			
			if(document.fom.odname.value =='')  
	          { alert("原部门名称不能为空！");   
	        return false;} 
			if(document.fom.ojobno.value =='')  
	          { alert("原岗位编号不能为空！");   
	        return false;} 
			 for(var i=0;i< fom.ojobno.value.length;i++){
			var ch = fom.ojobno.value.charAt(i);
			if(ch<"0" || ch>"9"){
				alert("岗位编号为数字");
				return false;
			}
		} 
			if(document.fom.ojobname.value =='')  
	          { alert("原岗位名称不能为空！"); 
		  
	        return false;} 
			 for(var i=0;i< fom.ndno.value.length;i++){
			var ch = fom.ndno.value.charAt(i);
			if(ch<"0" || ch>"9"){
				alert("部门编号为数字");
				return false;
			}
		} 
			if(document.fom.ndno.value =='')  
	          { alert("部门编号不能为空！"); 
		  
	        return false;} 
			if(document.fom.ndname.value =='')  
	          { alert("部门名称不能为空！"); 
		  
	        return false;} 
			if(document.fom.njobno.value =='')  
	          { alert("岗位编号不能为空！"); 
		  
	        return false;} 
			if(document.fom.njobname.value =='')  
	          { alert("岗位名称不能为空！"); 
		  
	        return false;} 
			if(document.fom.chandate.value =='')  
	          { alert("必须填写调转日期！"); 
		  
	        return false;} 
			
			return true;                                                                   
	                                                                                         
	                                       
}
</script>



</head>

<body>
<div id="man_zone">

<%Skemp skemp = (Skemp)request.getAttribute("skemp"); %>

  <form action="<%=basePath %>ChangeServlet?ff=update&id=<%=skemp.getId() %>" onsubmit="return link();" method="post" name="fom" id="fom" target="manFrame" >
    <div class="MainDiv">
      <table width="97%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">部门岗位调动页面</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="102%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            <tr class="CTitle" >
              <td height="22" colspan="15" align="center" style="font-size:16px"><p>部门岗位调动报表</p>
                <p>&nbsp;</p></td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td rowspan="4" align="center"><div align="center">
                  <p>调动员工基本信息</p>
                </div></td>
              <td height="30"><div align="center" class="STYLE3">员工编号</div></td>
              <td><div align="center" class="STYLE3">员工姓名</div></td>
              <td><div align="center" class="STYLE3">性别</div></td>
              <td><div align="center" class="STYLE3">出生日期</div></td>
              <td width="71"><div align="center" class="STYLE3">政治面貌</div></td>
              <td width="71"><div align="center" class="STYLE3">民族</div></td>
              <td width="71"><div align="center" class="STYLE3">籍贯</div></td>
              <td><div align="center" class="STYLE3">身份证号</div>
                  <div align="center" class="STYLE3"></div></td>
              <td colspan="3"><div align="center" class="STYLE3">婚姻状况</div></td>
              <td width="44" ><div align="center" class="STYLE3">身高</div></td>
              <td width="43"><div align="center" class="STYLE3">血型</div></td>
              <td><div align="center" class="STYLE3">联系电话</div></td>
            </tr>
            <tr bgcolor="#EEEEEE">
            <%
             
                  if(skemp.getName()==null)
                  {
                  %>
                  <tr><td colspan="12">没有符合条件的数据</td></tr>
                  <%}else{ 
                	  
                  %>
              <td height="30"><div align="center" class="STYLE3"><%=skemp.getId() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getName() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getSex() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getBir() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getZzmm() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getNational() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getIdcard() %></div>
                  <div align="center" class="STYLE3"></div></td>
              <td colspan="3"><div align="center" class="STYLE3">未婚</div>
                  <div align="center" class="STYLE3"></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getHeight() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getBloodtype() %></div></td>
              <td width="85"><div align="center" class="STYLE3"><%=skemp.getTele() %></div></td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td><div align="center" class="STYLE3">出生地</div></td>
              <td><div align="center" class="STYLE3">户口所在地</div></td>
              <td><div align="center" class="STYLE3">最高学历</div></td>
              <td><div align="center" class="STYLE3">最高学位</div></td>
              <td colspan="2"><div align="center" class="STYLE3">毕业院校</div></td>
              <td><span class="STYLE3">毕业专业</span></td>
              <td><span class="STYLE3">所学专业</span></td>
              <td colspan="4"><div align="center" class="STYLE3">毕业日期</div></td>
              <td colspan="2"><div align="center" class="STYLE3">电子邮件</div></td>
              </tr>
            <tr bgcolor="#EEEEEE">
              <td height="37"><div align="center" class="STYLE3"><%=skemp.getBirthplace() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getHkplace() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getXl() %></div></td>
              <td><div align="center" class="STYLE3"><%=skemp.getDegree() %></div></td>
              <td colspan="2"><div align="center" class="STYLE3"><%=skemp.getGraduateschool() %></div></td>
              <td><span class="STYLE3"><%=skemp.getProfessional() %></span></td>
              <td><span class="STYLE3"><%=skemp.getProfessional() %></span></td>
              <td colspan="4"><div align="center" class="STYLE3">
                <div align="center" class="STYLE3"><%=skemp.getGraduatetime() %></div>
              </div></td>
              <td colspan="2"><div align="center" class="STYLE3"><%=skemp.getMail() %></div></td>
              </tr>
            <tr bgcolor="#EEEEEE">
              <td width="55" rowspan="2" align="center"><div align="center" class="STYLE3">调转信息</div></td>
              <td width="70" height="30"><div align="center" class="STYLE3">原部门编号<span class="STYLE4">*</span></div></td>
              <td width="70"><div align="center" class="STYLE3">原部门名称<span class="STYLE4">*</span></div></td>
              <td width="71"><div align="center" class="STYLE3">原岗位编号<span class="STYLE4">*</span></div></td>
              <td width="71"><div align="center" class="STYLE3">原岗位名称<span class="STYLE4">*</span></div></td>
              <td><div align="center" class="STYLE3">新部门编号<span class="STYLE4">*</span></div></td>
              <td><div align="center" class="STYLE3">新部门名称<span class="STYLE4">*</span></div></td>
              <td><div align="center" class="STYLE3">新岗位编号<span class="STYLE4">*</span></div></td>
              <td width="98"><div align="center" class="STYLE3">新岗位名称<span class="STYLE4">*</span></div></td>
              <td colspan="4"><div align="center" class="STYLE3">调转类型</div>
                  <div align="center" class="STYLE3"></div></td>
              <td colspan="2"><div align="center" class="STYLE3">调转日期<span class="STYLE4">*</span></div></td>
              </tr>
              
              <%}
                  %>
            <tr bgcolor="#EEEEEE">
              <td width="70" height="32" bgcolor="#FFFFFF" ><span class="STYLE3">
                <label></label>
                <label> </label>
                <div align="center">
                  <span class="STYLE3"><%=skemp.getDpid() %>
                </div>
              </span></td>
              <td bgcolor="#FFFFFF" ><div align="center" class="STYLE3">
                  <label>
                   <span class="STYLE3"><%=skemp.getDpname() %>
                  </label>
              </div></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label>
                 <span class="STYLE3"><%=skemp.getJobid() %>
                </label>
              </span></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label>
                 <span class="STYLE3"><%=skemp.getJobname() %>
                </label>
              </span></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label>
                <input name="ndno" type="text" size="10" />
                </label>
              </span></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label>
                <input name="ndname" type="text" size="10" />
                </label>
              </span></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label>
                <input name="njobno" type="text" size="10" />
                </label>
              </span></td>
              <td bgcolor="#FFFFFF"><span class="STYLE3">
                <label></label>
                <label> </label>
                <div align="center">
                  <input name="njobname" type="text" size="10" />
                </div>
              </span></td>
              <td colspan="2" bgcolor="#FFFFFF"><div align="center" class="STYLE3">
                  <label>
                  <select name="select">
                    <option value="主动">主动</option>
                    <option value="被动">被动</option>
                  </select>
                  </label>
                </div>
                  <div align="center" class="STYLE3">
                    <label></label>
                  </div>
                <div align="center" class="STYLE3"></div></td>
              <td colspan="2" bgcolor="#FFFFFF"><span class="STYLE3">
                <select name="select2">
                  <option value="升职">升职</option>
                  <option value="降职">降职</option>
                </select>
              </span></td>
               <td colspan="2" bgcolor="#FFFFFF"><div align="center" class="STYLE3">
                  <label></label>
                  <label>
                  <input name="chandate" type="text" size="12" onclick="setday(this)"  />
                  </label>
              </div></td>
              </tr>
          </table></td>
        </tr>
      </table>
	  <br>
      <div align="center">
        <input type="submit" name="Submit" value="调转" />
       &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
<input type="button" name="ca" value="取消" />
      </div>
    </div>
  </form>
</div>
</body>
</html>
