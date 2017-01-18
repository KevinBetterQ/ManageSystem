// 导航栏配置文件
var outlookbar=new outlook();
var t;
t=outlookbar.addtitle('部门管理','组织管理',1)
outlookbar.additem('部门添加',t,'insert.jsp')
outlookbar.additem('部门查询',t,'../DepartmentServlet?service=all')
t=outlookbar.addtitle('岗位管理','组织管理',1)
outlookbar.additem('岗位添加',t,'insertskjob.jsp')
outlookbar.additem('岗位查询',t,'../SkjobServlet?service=all')


t=outlookbar.addtitle('入职管理','人员管理',1)
outlookbar.additem('输入员工',t,'entry.jsp')
/*outlookbar.additem('查询人才库',t,'newempinsert.html')*/

/*t=outlookbar.addtitle('试用期管理','人员管理',1)
outlookbar.additem('试用期审查',t,'showselect.html')
outlookbar.additem('已转正员工查询',t,'showselectzs.html')*/

t=outlookbar.addtitle('离职管理','人员管理',1)
outlookbar.additem('员工离职办理',t,'leavingselect.jsp')
outlookbar.additem('已离职员工查询',t,'leavingse.jsp')


t=outlookbar.addtitle('调动管理','调动管理',1)
outlookbar.additem('部门岗位调动',t,'movecheck.jsp')
/*outlookbar.additem('已调动员工查询',t,'sourchmeth.jsp')*/
outlookbar.additem('部门调动查询',t,'selectchangedept.jsp')
outlookbar.additem('岗位调动查询',t,'selectchangejob.jsp')

t=outlookbar.addtitle('员工信息中心','信息管理',1)
/*outlookbar.additem('人才库查询',t,'DBselect.html')*/
outlookbar.additem('入职员工查询',t,'EMPDselect.jsp')



t=outlookbar.addtitle('报表管理','报表管理',1)
outlookbar.additem('新聘员工报表',t,'selectnewskemp.jsp')
outlookbar.additem('离职员工报表',t,'selretireemp.jsp')
outlookbar.additem('部门调动员工报表',t,'selectchangedept.jsp')
outlookbar.additem('岗位调动员工报表',t,'selectchangejob.jsp')
/*outlookbar.additem('人事月报',t,'selmothlist.html')*/

t=outlookbar.addtitle('系统管理','系统管理',1)
outlookbar.additem('添加管理员',t,'addmanager.jsp')
outlookbar.additem('查询管理员',t,'selectmanager.jsp')

outlookbar.additem('退出登录',t,'out.jsp')