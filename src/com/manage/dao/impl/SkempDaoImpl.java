package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.SkempDao;
import com.manage.dao.domain.Skemp;
import com.manage.utils.DbUtils;



public class SkempDaoImpl implements SkempDao{

	@Override
	public void insertSkemp(Skemp skemp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		//操作数据库
		
		String sql = "insert into skemp"
		+ "(id,name,sex,bir,idcard,toworktime,zzmm,"
		+ "national,native,tele,mail,height,bloodtype,"
		+ "birthplace,hkplace,xl,degree,graduateschool,professional,graduatetime,dpid,jobid,dpname,jobname)"
		+ "values(?,?,?,?,?,?,"
		+ "?,?,?,?,"
		+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, skemp.getId());
			pstmt.setString(2, skemp.getName());
			pstmt.setString(3, skemp.getSex());
			pstmt.setDate(4, skemp.getBir());
			pstmt.setString(5, skemp.getIdcard());
			pstmt.setDate(6, skemp.getToworktime());
			pstmt.setString(7, skemp.getZzmm());
			pstmt.setString(8, skemp.getNational());
			pstmt.setString(9, skemp.getNative_m());
			pstmt.setString(10, skemp.getTele());
			pstmt.setString(11, skemp.getMail());
			pstmt.setString(12, skemp.getHeight());
			pstmt.setString(13, skemp.getBloodtype());
			pstmt.setString(14, skemp.getBirthplace());
			pstmt.setString(15, skemp.getHkplace());
			pstmt.setString(16, skemp.getXl());
			pstmt.setString(17, skemp.getDegree());
			pstmt.setString(18, skemp.getGraduateschool());
			pstmt.setString(19, skemp.getProfessional());
			pstmt.setDate(20, skemp.getGraduatetime());
			pstmt.setInt(21, skemp.getDpid());
			pstmt.setInt(22, skemp.getJobid());
			pstmt.setString(23, skemp.getDpname());
			pstmt.setString(24, skemp.getJobname());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
		}
		
	}

	@Override
	public void updateSkemp(Skemp skemp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSkemp(Skemp skemp) {
		// TODO Auto-generated method stub
				Connection conn=null;
				PreparedStatement pstmt=null;
				
				try {
					conn=DbUtils.getConnection();
					String sql="delete from skemp where id=?";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, skemp.getId());
					
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					//4.关闭数据库		
					DbUtils.closePreparedStatement(pstmt);
					DbUtils.closeConnection(conn);
				}
		
	}

	@Override
	public List<Skemp> getSkemps() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs=null;
		List<Skemp> skemps = new ArrayList<Skemp>();
		
		String sql = "select * from skemp";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Skemp skemp = new Skemp();
				skemp.setId(rs.getInt("id"));
				skemp.setName(rs.getString("name"));
				skemp.setSex(rs.getString("sex"));
				skemps.add(skemp);
				/*Skemp skemp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emps.add(emp);*/
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeResultSet(rs);
		}

		return skemps;
	}

	@Override
	public Skemp getSkempById(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs=null;
		Skemp skemp = new Skemp();
		
		
		String sql = "select * from skemp where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				skemp.setId(rs.getInt("id"));
				skemp.setName(rs.getString("name"));
				skemp.setSex(rs.getString("sex"));
				skemp.setBir(rs.getDate("bir"));
				skemp.setIdcard(rs.getString("idcard"));
				//skemp.setToworktime(toworktime);
				skemp.setZzmm(rs.getString("zzmm"));
				skemp.setNational(rs.getString("national"));
				skemp.setNative_m(rs.getString("native"));
				skemp.setTele(rs.getString("tele"));
				skemp.setMail(rs.getString("mail"));
				skemp.setHeight(rs.getString("height"));
				skemp.setBloodtype(rs.getString("bloodtype"));
				skemp.setBirthplace(rs.getString("birthplace"));
				skemp.setHkplace(rs.getString("hkplace"));
				skemp.setXl(rs.getString("xl"));
				skemp.setDegree(rs.getString("degree"));
				skemp.setGraduateschool(rs.getString("graduateschool"));
				skemp.setGraduatetime(rs.getDate("graduatetime"));
				skemp.setProfessional(rs.getString("professional"));
				skemp.setDpid(rs.getInt("dpid"));
				skemp.setDpname(rs.getString("dpname"));
				skemp.setJobid(rs.getInt("jobid"));
				skemp.setJobname(rs.getString("jobname"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeResultSet(rs);
		}

		return skemp;
	}
	
}
