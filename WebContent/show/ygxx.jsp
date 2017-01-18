<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,com.manage.dao.domain.Skemp"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="css/common.css" type="text/css" />
<title>管理区域</title>
<style type="text/css">
<!--
.STYLE3 {font-size: 10; }
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

function link1(){                                                                                                  
	location.href="ygxx.html"
	 
		}    

</script>
</head>

<body>
<div id="man_zone">
  <form action="<%=basePath %>SkempServlet?service=update" onsubmit="return link();" method="post"  name="fom" id="fom" target="manFrame" >
    <div class="MainDiv">
    
      <table width="97%" border="0" cellpadding="0" cellspacing="0" class="CContent">
        <tr>
          <th class="tablestyle_title" ><div align="left">在职人员信息页面</div></th>
        </tr>
        <tr>
          <td class="CPanel"><table width="95%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
            <tr class="CTitle" >
              <td height="22" colspan="11" align="center" style="font-size:16px"><p>在职人员信息表</p>                </td>
            </tr>
            <%List<Skemp>  skemps=(List<Skemp>)request.getAttribute("skemps");
if(skemps==null)
{
%>
<tr><td colspan="10">没有符合条件的数据</td></tr>
<%}else{ 
	for(Skemp skemp:skemps)
	{
%>
            <tr bgcolor="#EEEEEE">
              <td rowspan="5" align="center"><div align="center">
                <p>员工基本信息</p>
                </div></td>
              <td width="84">员工编号*</td>
              <td width="107"><label>
                <input name="id" type="text" value="<%=skemp.getId() %>" size="15" />
              </label></td>
              <td width="84">姓名*</td>
              <td width="87"><label>
                <input name="name" type="text" value="<%=skemp.getName() %>" size="10" />
              </label></td>
              <td width="84">性别</td>
              <td width="89"><label>
                <input name="sex" type="text" value="<%=skemp.getSex() %>" size="10" />
              </label></td>
              <td width="84">出生日期*</td>
              <td width="88"><label>
                <input name="bir" type="text"onclick="setday(this)" value="<%=skemp.getBir() %>" size="10" />
              </label></td>
              <td width="84">身份证号*</td>
              <td width="179"><label>
			  <input name="idcard" type="text" value="<%=skemp.getIdcard() %>" size="10" />
              
              </label></td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td>部门*</td>
              <td><label>
                <input name="dpname" type="text" value="<%=skemp.getDpname() %>" size="15" />
              </label></td>
              <td>岗位*</td>
              <td><label>
                <input name="jobname" type="text" value="<%=skemp.getJobname() %>" size="12" />
              </label></td>
              <td>民族*</td>
              <td><label>
                 <input name="national" type="text" value="<%=skemp.getNational() %>" size="10" />
              </label></td>
              <td>毕业日期*</td>
              <td><label>
                <input name="graduatetime" type="text" onclick="setday(this)" value="<%=skemp.getGraduatetime() %>" size="10"/>
              </label></td>
              <td>参加工作日期*</td>
              <td><label>
                <input name="toworktime" type="text" onclick="setday(this)" value="<%=skemp.getToworktime() %>" size="10" />
              </label></td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td>用工形式*</td>
              <td><label>
                <select name="select3">
                  <option value="正式员工">正式员工</option>
                  <option value="临时员工">临时员工</option>
                </select>
              </label></td>
              <td>人员来源*</td>
              <td><label>
                <select name="select4">
                  <option value="社会招聘">社会招聘</option>
                  <option value="校园招聘">校园招聘</option>
                  <option value="其他">其他</option>
                </select>
              </label></td>
              <td>政治面貌</td>
              <td><label>
                 <input name="zzmm" type="text" value="<%=skemp.getZzmm() %>" size="10" />
              </label></td>
              <td>出生地</td>
              <td><label>
                <input name="birthplace" type="text" value="<%=skemp.getBirthplace() %>" size="10" />
              </label></td>
              <td>籍贯</td>
              <td><label>
                <input name="native" type="text" value="<%=skemp.getNative_m() %>" size="10" />
              </label></td>
            </tr>
            <tr bgcolor="#EEEEEE">
              <td>联系电话</td>
              <td><input name="tele" type="text" value="<%=skemp.getTele() %>" size="10" /></td>
              <td>电子邮件</td>
              <td><input name="mail" type="text" value="<%=skemp.getMail() %>" size="10" /></td>
              <td>身高</td>
              <td><input name="height" type="text" value="<%=skemp.getHeight() %>" size="10" /></td>
              <td>血型</td>
              <td><input name="bloodtype" type="text" value="<%=skemp.getBloodtype() %>" size="10" /></td>
              </label></td>
              <td>婚姻状况</td>
              <td><label>
                <select name="select7">
                  <option value="已婚">已婚</option>
                  <option value="未婚">未婚</option>
                  <option value="丧偶">丧偶</option>
                  <option value="离婚">离婚</option>
                  <option value="其他">其他</option>
                </select>
              </label></td>
            </tr>
            
            <tr bgcolor="#EEEEEE">
              <td>户口所在地</td>
              <td><input name="hkplace" type="text" value="<%=skemp.getHkplace() %>" size="10" /></td>
              <td>最高学历</td>
                <td><input name="xl" type="text" value="<%=skemp.getXl() %>" size="10" /></td>
              <td>最高学位</td>
               <td><input name="degree" type="text" value="<%=skemp.getDegree() %>" size="10" /></td>
              <td>毕业院校</td>
             <td><input name="graduateschool" type="text" value="<%=skemp.getGraduateschool() %>" size="10" /></td>
              <td>所学专业</td>
			   <td><input name="professional" type="text" value="<%=skemp.getProfessional() %>" size="10" /></td>
              
            </tr>
            
             <%}} %>
            
          </table></td>
        </tr>
      </table>
	  <br>
      <div align="center">
        
       &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;     
<input  type="reset"  name="Submit2" value="取消" />
&nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;
&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  type="submit" name="Submit5" value="修改" onclick="link1();" />
      </div>
    </div>
  </form>
</div>
</body>
</html>
