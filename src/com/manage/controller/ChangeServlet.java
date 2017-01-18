package com.manage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.ChangeSkdeptDao;
import com.manage.dao.SkempDao;
import com.manage.dao.domain.ChangeSkdept;
import com.manage.dao.domain.Skemp;
import com.manage.dao.impl.ChangeSkdeptDaoImpl;
import com.manage.dao.impl.SkempDaoImpl;
import com.manage.service.SelectChangeSkeptService;
import com.manage.service.impl.SelectChangeSkeptServiceImpl;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
		response.setCharacterEncoding("UTF-8");	
		String service=request.getParameter("ff");
		if("select".equals(service))
		{	
			int id = Integer.valueOf(request.getParameter("empid"));
			SkempDao skempDao = new SkempDaoImpl();
			Skemp skemp = skempDao.getSkempById(id);
			
			request.setAttribute("skemp", skemp);
			request.getRequestDispatcher("show/updatesel.jsp").forward(request, response);
		}else if("update".equals(service)){
			int id = Integer.valueOf(request.getParameter("id"));
	
			SkempDao skempDao = new SkempDaoImpl();
			Skemp skemp = skempDao.getSkempById(id);
			
			//change数据库相关
			String olddept = skemp.getDpname();
			String newdept = request.getParameter("ndname");
			String oldjob = skemp.getJobname();
			String newjob = request.getParameter("njobname");
			String deptype = request.getParameter("select");
			String type = request.getParameter("select2");
			String jobtime = request.getParameter("chandate");
			
			ChangeSkdept changeSkdept = new ChangeSkdept();
			changeSkdept.setId(id);
			changeSkdept.setOlddept(olddept);
			changeSkdept.setNewdept(newdept);
			changeSkdept.setOldjob(oldjob);
			changeSkdept.setNewjob(newjob);
			changeSkdept.setDeptype(deptype);
			changeSkdept.setType(type);
			changeSkdept.setJobtime(jobtime);
			
			
			//skemp表相关
			int dpid = Integer.valueOf(request.getParameter("ndno"));
			int jobid = Integer.valueOf(request.getParameter("njobno"));
			String dpname =  request.getParameter("ndname");
			String jobname = request.getParameter("njobname");	
			
			
			Skemp skempChange = new Skemp();
			skempChange.setId(id);
			skempChange.setDpid(dpid);
			skempChange.setJobid(jobid);
			skempChange.setDpname(dpname);
			skempChange.setJobname(jobname);
			
			SkempDao skempDao2 = new SkempDaoImpl();
			skempDao2.updateSkChange(skempChange);
			
			//相应服务
			ChangeSkdeptDao changeSkdeptDao = new ChangeSkdeptDaoImpl();
			changeSkdeptDao.insertChange(changeSkdept);
			
			request.getRequestDispatcher("show/sec.html").forward(request, response);
			
		}else if("changed".equals(service)){
			/*request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			String time1=request.getParameter("time1");
			String time2=request.getParameter("time2");
			
			SelectChangeSkeptService selectChangeSkeptService=new SelectChangeSkeptServiceImpl();
			List<ChangeSkdept> changeSkdepts=selectChangeSkeptService.getChangeSkdept(time1, time2);
			request.setAttribute("changedepts", changeSkdepts);
			List<ChangeSkdept> changeSkjobs=selectChangeSkeptService.getChangeSkjob(time1, time2);
			
			request.setAttribute("changeSkjobs", changeSkjobs);
			
			request.getRequestDispatcher("show/movedlist.jsp").forward(request, response);
			
			SelectChangeSkeptService selectChangeSkeptService=new SelectChangeSkeptServiceImpl();
			List<ChangeSkdept> changeSkdepts=selectChangeSkeptService.getChangeSkdept(time1, time2);
			request.setAttribute("changedepts", changeSkdepts);
			request.getRequestDispatcher("show/selectchangedept1.jsp").forward(request, response);
			
			SelectChangeSkeptService selectChangeSkeptService=new SelectChangeSkeptServiceImpl();
			List<ChangeSkdept> changeSkjobs=selectChangeSkeptService.getChangeSkjob(time1, time2);
			request.setAttribute("changeSkjobs", changeSkjobs);
			request.getRequestDispatcher("show/selectchangejob1.jsp").forward(request, response);*/
		}
	}

}
