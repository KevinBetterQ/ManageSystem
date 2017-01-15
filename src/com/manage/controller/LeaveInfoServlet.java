package com.manage.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class LeaveInfoServlet
 */
@WebServlet("/LeaveInfoServlet")
public class LeaveInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveInfoServlet() {
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

		//处理请求
		int id = Integer.parseInt(request.getParameter("ygnum"));
		
		SkempDao skempDao = new SkempDaoImpl();
		Skemp skemp = skempDao.getSkempById(id);
		request.setAttribute("skemp", skemp);
		
		request.getRequestDispatcher("staff/information2.jsp").forward(request, response);
		
		
		/*//调用相应的业务逻辑
		LeaveDao leaveDao = new LeaveDaoImpl();
		Leave leave = leaveDao.getLeavesById(empno);
		request.setAttribute("leave", leave);
		//找到某个视图响应回去
		request.getRequestDispatcher("staff/leavingInformation.jsp").forward(request, response);*/
	}

}
