package com.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.LeaveDao;
import com.manage.dao.SkempDao;
import com.manage.dao.domain.Leave;
import com.manage.dao.domain.Skemp;
import com.manage.dao.impl.LeaveDaoImpl;
import com.manage.dao.impl.SkempDaoImpl;
import com.manage.service.SelectNewSkempService;
import com.manage.service.impl.SelectNewSkempServiceImpl;


/**
 * Servlet implementation class LeaveServlet
 */
@WebServlet("/LeaveServlet")
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");     //解决响应时乱码

		String string = request.getParameter("flag");
		if("select".equals(string)){
			//处理请求
			int empno = Integer.parseInt(request.getParameter("ygnum"));
			
			SkempDao skempDao = new SkempDaoImpl();
			Skemp skemp = skempDao.getSkempById(empno);
			if(skemp != null)
			request.setAttribute("skemp", skemp);
			request.getRequestDispatcher("show/leavingInformation.jsp").forward(request, response);
		}else if("leave".equals(string)){
			int empno = Integer.parseInt(request.getParameter("empno"));
			SkempDao skempDao = new SkempDaoImpl();
			Skemp skemp = skempDao.getSkempById(empno);
			request.setAttribute("skemp", skemp);
			request.getRequestDispatcher("show/leaving.jsp").forward(request, response);
		}else if("leaved".equals(string)){
			int empno = Integer.parseInt(request.getParameter("ygnum"));
			LeaveDao leaveDao = new LeaveDaoImpl();
			Leave leave = leaveDao.getLeavesById(empno);
			request.setAttribute("leave", leave);
			request.getRequestDispatcher("show/leaved.jsp").forward(request, response);
		}else if("leaveselect".equals(string)){
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String time1=request.getParameter("time1");
			String time2=request.getParameter("time2");
			System.out.println(time1+"\t"+time2);
			LeaveDao leaveDao = new LeaveDaoImpl();
			List<Leave> leaves = leaveDao.getLeavesByTime(time1, time2);
				
			request.setAttribute("leaves", leaves);
			request.getRequestDispatcher("show/leavelist.jsp").forward(request, response);
		}
	}

}
