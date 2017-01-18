package com.manage.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.dao.domain.Skemp;
import com.manage.service.SkempService;
import com.manage.service.impl.SkempServiceImpl;



/**
 * Servlet implementation class SkempServlet
 */
@WebServlet("/SkempServlet")
public class SkempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SkempServlet() {
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
		response.setCharacterEncoding("UTF-8");	
		String service=request.getParameter("service");
		if("all".equals(service))
		{	
			request.getRequestDispatcher("show/sec.html").forward(request, response);
			//request.getRequestDispatcher("show/index.html").forward(request, response);
		}else if("select".equals(service))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			SkempService skempService=new SkempServiceImpl();
			List<Skemp> skemps=skempService.getSkemps(id);
			request.setAttribute("skemps", skemps);			
			request.getRequestDispatcher("show/ygxx.jsp").forward(request, response);
		}else if("update".equals(service))
		{
			//处理请求
			String name=request.getParameter("name");
			String sex=request.getParameter("sex");
			String bir=request.getParameter("bir");
			String idcard=request.getParameter("idcard");
			String dpname=request.getParameter("dpname");
			int id=Integer.parseInt(request.getParameter("id"));
			String jobname=request.getParameter("jobname");
			String national=request.getParameter("national");
			String graduatetime=request.getParameter("graduatetime");
			String toworktime=request.getParameter("toworktime");
			String zzmm=request.getParameter("zzmm");
			String birthplace=request.getParameter("birthplace");
			String native_m=request.getParameter("native");
			String tele=request.getParameter("tele");
			String mail=request.getParameter("mail");
			String height=request.getParameter("height");
			String bloodtype=request.getParameter("bloodtype");
			String hkplace=request.getParameter("hkplace");
			String xl=request.getParameter("xl");
			String degree=request.getParameter("degree");
			String graduateschool=request.getParameter("graduateschool");
			String professional=request.getParameter("professional");
			
			Skemp skemp=new Skemp();
			skemp.setName(name);
			skemp.setId(id);
			skemp.setBir(Date.valueOf(bir));
			skemp.setSex(sex);
			skemp.setId(id);
			skemp.setIdcard(idcard);
			skemp.setProfessional(professional);
			skemp.setDpname(dpname);
			skemp.setJobname(jobname);
			skemp.setNational(national);
			skemp.setGraduatetime(Date.valueOf(graduatetime));
			skemp.setToworktime(Date.valueOf(toworktime));
			skemp.setZzmm(zzmm);
			skemp.setBirthplace(birthplace);
			skemp.setNative_m(native_m);
			skemp.setTele(tele);
			skemp.setMail(mail);
			skemp.setHeight(height);
			skemp.setBloodtype(bloodtype);
			skemp.setHkplace(hkplace);
			skemp.setXl(xl);
			skemp.setDegree(degree);
			skemp.setGraduateschool(graduateschool);
			skemp.setGraduatetime(Date.valueOf(graduatetime));
			skemp.setId(id);
			
			//调用相应的业务逻辑
			SkempService skempService=new SkempServiceImpl();
			skempService.updateSkemp(skemp);

			//找到某个视图响应回去
			System.out.println("update");
		
			request.getRequestDispatcher("SkempServlet?service=all").forward(request, response);
			
		}
	}

}
