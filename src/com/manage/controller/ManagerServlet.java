package com.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.domain.Manager;
import com.manage.service.ManagerService;
import com.manage.service.impl.ManagerServiceImpl;





/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String service=request.getParameter("service");
		if("all".equals(service))
		{	
			response.sendRedirect("show/index.html");
			//request.getRequestDispatcher("show/index.html").forward(request, response);
		}else if("add".equals(service))
		{
			//处理请求
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String explanation1=request.getParameter("explanation1");
			String explanation2=request.getParameter("explanation2");
			String explanation3=request.getParameter("explanation3");
			int id=Integer.parseInt(request.getParameter("id"));
			Manager manager=new Manager();
			manager.setName(name);
			manager.setPass(pass);
			manager.setExplanation1(explanation1);
			manager.setExplanation2(explanation2);
			manager.setExplanation3(explanation3);
			manager.setId(id);
			
			//调用相应的业务逻辑
			ManagerService managerService=new ManagerServiceImpl();
			managerService.insertManager(manager);
			//找到某个视图响应回去
			request.getRequestDispatcher("show/sec.html").forward(request, response);
			
		}else if("select".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			ManagerService managerService=new ManagerServiceImpl();
			List<Manager> managers=managerService.getManagers(id);
			request.setAttribute("managers", managers);
			request.getRequestDispatcher("show/selmanger.jsp").forward(request, response);
		}else if("update".equals(service))
		{
			//处理请求
			System.out.println("OK");
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			String explanation1=request.getParameter("explanation1");
			String explanation2=request.getParameter("explanation2");
			String explanation3=request.getParameter("explanation3");
			int id=Integer.parseInt(request.getParameter("id"));
			
			Manager manager=new Manager();
			manager.setName(name);
			manager.setPass(pass);
			manager.setExplanation1(explanation1);
			manager.setExplanation2(explanation2);
			manager.setExplanation3(explanation3);
			manager.setId(id);
			
			//调用相应的业务逻辑
			ManagerService managerService=new ManagerServiceImpl();
			managerService.updateManager(manager);

			//找到某个视图响应回去
		
			request.getRequestDispatcher("show/sec.html").forward(request, response);
			
		}
		else if("modify".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			ManagerService managerService=new ManagerServiceImpl();
			Manager manager=managerService.getManagerByDeptno(id);
		
		request.setAttribute("manager", manager);
			//找到某个视图响应回去
			request.getRequestDispatcher("show/updatemanager.jsp").forward(request, response);
			
		}else if("delete".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			//调用相应的业务逻辑
			ManagerService managerService=new ManagerServiceImpl();
			managerService.deleteManager(id);
			//找到某个视图响应回去
			request.getRequestDispatcher("show/sec.html").forward(request, response);
			
		}
		else if("login".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String pass=request.getParameter("pass");
			//调用相应的业务逻辑
			ManagerService managerService=new ManagerServiceImpl();
			Manager manager=managerService.loginManager(id);
			//找到某个视图响应回去
			//System.out.println(manager.getPass());
			//System.out.println(manager.getPass());
			if(pass.equals(manager.getPass()))
				request.getRequestDispatcher("ManagerServlet?service=all").forward(request, response);
			else
				//request.getRequestDispatcher("show/login.jsp").forward(request, response);
				response.sendRedirect("show/login.jsp");
			
		}
	}

}
