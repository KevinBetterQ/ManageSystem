package com.manage.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.SkStaffDao;
import com.manage.dao.SkempDao;
import com.manage.dao.domain.Skemp;
import com.manage.dao.domain.Skstaff;
import com.manage.dao.impl.SkStaffDaoImpl;
import com.manage.dao.impl.SkempDaoImpl;
import com.manage.service.SkempService;
import com.manage.service.impl.SkempServiceImpl;


/**
 * Servlet implementation class EntrySerclet
 */
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryServlet() {
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
		int id = Integer.parseInt(request.getParameter("userid"));
		String name = request.getParameter("ename");
		String sex = request.getParameter("sex");
		Date bir = Date.valueOf(request.getParameter("bthday"));
		String idcart = request.getParameter("id");
		//Date toworktime = Date.valueOf(request.getParameter(""));
		String zzmm = request.getParameter("zzmm");
		String national = request.getParameter("national");
		String native_m = request.getParameter("native");
		String tele = request.getParameter("tele");
		String mail = request.getParameter("mail");
		String height = request.getParameter("height");
		String bloodtype = request.getParameter("bloodtype");
		String birthplcae = request.getParameter("birplace");
		String hkplace = request.getParameter("hkplace");
		String xl = request.getParameter("xl");
		String degree = request.getParameter("degree");
		String graduateschool = request.getParameter("graschool");
		String professional = request.getParameter("professional");
		Date graduatetime = Date.valueOf(request.getParameter("gratime"));
		int dpid = Integer.parseInt(request.getParameter("deptid"));
		int jobid = Integer.parseInt(request.getParameter("jobid"));
		String dpname = request.getParameter("deptname");
		String jobname = request.getParameter("jobname");
		
		String source = request.getParameter("ryly");
		
		//部门相关
		/*int did = Integer.parseInt(request.getParameter("deptid"));
		String  dname = request.getParameter("deptname");
		String  dtype = request.getParameter("");
		int dtele = Integer.parseInt(request.getParameter(""));
		String  dfax = request.getParameter("");
		String  discrip = request.getParameter("");
		int  dsuper = Integer.parseInt(request.getParameter(""));
		String createtime = request.getParameter("");*/
		
		Skemp skemp = new Skemp();
		skemp.setId(id);
		skemp.setName(name);
		skemp.setSex(sex);
		skemp.setBir(bir);
		skemp.setIdcard(idcart);
		//skemp.setToworktime(toworktime);
		skemp.setZzmm(zzmm);
		skemp.setNational(national);
		skemp.setNative_m(native_m);
		skemp.setTele(tele);
		skemp.setMail(mail);
		skemp.setHeight(height);
		skemp.setBloodtype(bloodtype);
		skemp.setBirthplace(birthplcae);
		skemp.setHkplace(hkplace);
		skemp.setXl(xl);
		skemp.setDegree(degree);
		skemp.setGraduateschool(graduateschool);
		skemp.setGraduatetime(graduatetime);
		skemp.setProfessional(professional);
		skemp.setDpid(dpid);
		skemp.setDpname(dpname);
		skemp.setJobid(jobid);
		skemp.setJobname(jobname);
		
		Skstaff skstaff = new Skstaff();
		skstaff.setEmpno(id);
		skstaff.setJobid(jobid);
		skstaff.setSource(source);
		
		
		
		//调用相应的业务逻辑
		SkempService skempService = new SkempServiceImpl();
		skempService.insertSkemp(skemp);
		SkStaffDao skStaffDao = new SkStaffDaoImpl();
		skStaffDao.insertSkStaff(skstaff);
		
		
		//找到某个视图响应回去
		request.getRequestDispatcher("show/sec.html").forward(request, response);
		
		
	}

}
