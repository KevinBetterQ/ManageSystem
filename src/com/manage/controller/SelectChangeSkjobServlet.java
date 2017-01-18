package com.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.domain.ChangeSkdept;
import com.manage.service.SelectChangeSkeptService;
import com.manage.service.impl.SelectChangeSkeptServiceImpl;



/**
 * Servlet implementation class SelectChangeSkjobServlet
 */
@WebServlet("/SelectChangeSkjobServlet")
public class SelectChangeSkjobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectChangeSkjobServlet() {
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
		String time1=request.getParameter("time");
		String time2=request.getParameter("time2");
		//String bumen=request.getParameter("bumen");

		SelectChangeSkeptService selectChangeSkeptService=new SelectChangeSkeptServiceImpl();
		List<ChangeSkdept> changeSkjobs=selectChangeSkeptService.getChangeSkjob(time1, time2);
			
		request.setAttribute("changeSkjobs", changeSkjobs);
  
			
		request.getRequestDispatcher("show/selectchangejob1.jsp").forward(request, response);
	}

}
