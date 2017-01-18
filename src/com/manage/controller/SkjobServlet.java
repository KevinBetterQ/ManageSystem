package com.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.domain.Skjob;
import com.manage.service.SkjobService;
import com.manage.service.impl.SkjobServiceImpl;



/**
 * Servlet implementation class SkjobServlet
 */
@WebServlet("/SkjobServlet")
public class SkjobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkjobServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String service=request.getParameter("service");
		if("all".equals(service))
		{
			SkjobService skjobService=new SkjobServiceImpl();
			List<Skjob> skjobs=skjobService.getSkjobs();
			
			request.setAttribute("skjobs", skjobs);
			
			request.getRequestDispatcher("show/selectskjob.jsp").forward(request, response);
		}else if ("select".equals(service)) {
			int id=Integer.parseInt(request.getParameter("id"));
			SkjobService skjobService=new SkjobServiceImpl();
			List<Skjob> skjobs=skjobService.getSkjobstaff(id);
			
			request.setAttribute("skjobs", skjobs);
			
			request.getRequestDispatcher("show/selectskjobstaff.jsp").forward(request, response);
		}
		else if("add".equals(service))
		{
			//处理请求
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			int limit=Integer.parseInt(request.getParameter("limit"));
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			//Date createtime=Date.valueOf(request.getParameter("createtime"));
			
			Skjob skjob=new Skjob();
			skjob.setId(id);//(deptno);
			skjob.setName(name);//dept.setDname(dname);
			skjob.setType(type);//dept.setLoc(loc);
			skjob.setLimit(limit);
			skjob.setDeptno(deptno);
			//department.setCreatetime(createtime);
			
			//调用相应的业务逻辑
			SkjobService skjobService=new SkjobServiceImpl();
			skjobService.insertSkjob(skjob);
			//找到某个视图响应回去
			request.getRequestDispatcher("SkjobServlet?service=all").forward(request, response);
		}else if("update".equals(service))
		{
			//处理请求
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			int limit=Integer.parseInt(request.getParameter("limit"));
			int deptno=Integer.parseInt(request.getParameter("deptno"));
			//String createtime=request.getParameter("createtime");
			//String[] strs=createtime.split(" ");
			Skjob skjob=new Skjob();
			skjob.setId(id);//(deptno);
			skjob.setName(name);//dept.setDname(dname);
			skjob.setType(type);//dept.setLoc(loc);
			skjob.setLimit(limit);
			skjob.setDeptno(deptno);

			//department.setCreatetime(strs[0]);
			
			//调用相应的业务逻辑
			SkjobService skjobService=new SkjobServiceImpl();
			skjobService.updateSkjob(skjob);
			
			//找到某个视图响应回去
		
			request.getRequestDispatcher("SkjobServlet?service=all").forward(request, response);
			
		}
		else if("delete".equals(service))
		{
			
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			SkjobService skjobService=new SkjobServiceImpl();
			skjobService.deleteSkjob(id);
			
			//找到某个视图响应回去
			request.getRequestDispatcher("SkjobServlet?service=all").forward(request, response);
			
		}else if("modify".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			SkjobService skjobService=new SkjobServiceImpl();
			Skjob skjob=skjobService.getSkjobById(id);
		
			request.setAttribute("skjob", skjob);
			//找到某个视图响应回去
			request.getRequestDispatcher("show/updateskjob.jsp").forward(request, response);
			
		}
	}
}
