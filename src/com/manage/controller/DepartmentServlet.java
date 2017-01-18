package com.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.domain.Department;
import com.manage.service.DepartmentService;
import com.manage.service.impl.DepartmentServiceImpl;





/**
 * Servlet implementation class DepartmentServlet
 */
@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
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
			//DeptService deptService=new DeptServiceImpl();
			//List<Dept> depts=deptService.getDepts();
			DepartmentService departmentService=new DepartmentServiceImpl();
			List<Department> departments=departmentService.getDepartments();
			
			request.setAttribute("departments", departments);
			
			request.getRequestDispatcher("show/addselec.jsp").forward(request, response);
		}else if ("select".equals(service)) {
			int id=Integer.parseInt(request.getParameter("id"));
			DepartmentService departmentService=new DepartmentServiceImpl();
			List<Department> departments=departmentService.getDepartmentstaff(id);
			
			request.setAttribute("departments", departments);
			
			request.getRequestDispatcher("show/selecdepartmentstaff.jsp").forward(request, response);
			
		}else if("add".equals(service))
		{
			//处理请求
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			int tele=Integer.parseInt(request.getParameter("tele"));
			String fax=request.getParameter("fax");
			String discrip=request.getParameter("discrip");
			String createtime=request.getParameter("createtime");
			//Date createtime=Date.valueOf(request.getParameter("createtime"));
			
			Department department=new Department();
			department.setId(id);//(deptno);
			department.setName(name);//dept.setDname(dname);
			department.setType(type);//dept.setLoc(loc);
			department.setTele(tele);
			department.setFax(fax);
			department.setDiscrip(discrip);
			department.setCreatetime(createtime);
			//department.setCreatetime(createtime);
			
			//调用相应的业务逻辑
			DepartmentService departmentService=new DepartmentServiceImpl();
			departmentService.insertDpartment(department);
			//找到某个视图响应回去
			request.getRequestDispatcher("DepartmentServlet?service=all").forward(request, response);
		}else if("update".equals(service))
		{
			//处理请求
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			int tele=Integer.parseInt(request.getParameter("tele"));
			String fax=request.getParameter("fax");
			String discrip=request.getParameter("discrip");
			String createtime=request.getParameter("createtime");
			String[] strs=createtime.split(" ");
			Department department=new Department();
			department.setId(id);//(deptno);
			department.setName(name);//dept.setDname(dname);
			department.setType(type);//dept.setLoc(loc);
			department.setTele(tele);
			department.setFax(fax);
			department.setDiscrip(discrip);
			department.setCreatetime(strs[0]);
			
			//调用相应的业务逻辑
			DepartmentService departmentService=new DepartmentServiceImpl();
			departmentService.updateDpartment(department);
			
			//找到某个视图响应回去
		
			request.getRequestDispatcher("DepartmentServlet?service=all").forward(request, response);
			
		}
		else if("delete".equals(service))
		{
			
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			DepartmentService departmentService=new DepartmentServiceImpl();
			departmentService.deleteDpartment(id);
			
			//找到某个视图响应回去
			request.getRequestDispatcher("DepartmentServlet?service=all").forward(request, response);
			
		}else if("modify".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			DepartmentService departmentService=new DepartmentServiceImpl();
			Department department=departmentService.getDepartmentById(id);
		
			request.setAttribute("department", department);
			//找到某个视图响应回去
			request.getRequestDispatcher("show/update.jsp").forward(request, response);
			
		}
	}

}
