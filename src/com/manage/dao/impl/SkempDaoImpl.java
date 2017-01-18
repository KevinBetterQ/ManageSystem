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
		Connection conn=null;
		PreparedStatement pstmt=null;


		try {
			conn=DbUtils.getConnection();
			String sql="update skemp set name=?,sex=?,bir=?,idcard=?,toworktime=?,zzmm=?,"
		+ "national=?,native=?,tele=?,mail=?,height=?,bloodtype=?,"
		+ "birthplace=?,hkplace=?,xl=?,degree=?,graduateschool=?,professional=?,graduatetime=?,dpname=?,jobname=? where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,skemp.getName());
			pstmt.setString(2,skemp.getSex());
			pstmt.setDate(3,skemp.getBir());
			pstmt.setString(4,skemp.getIdcard());
			pstmt.setDate(5,skemp.getToworktime());
			pstmt.setString(6, skemp.getZzmm());
			pstmt.setString(7, skemp.getNational());
			pstmt.setString(8, skemp.getNative_m());
			pstmt.setString(9, skemp.getTele());
			pstmt.setString(10, skemp.getMail());
			pstmt.setString(11, skemp.getHeight());
			pstmt.setString(12, skemp.getBloodtype());
			pstmt.setString(13, skemp.getBirthplace());
			pstmt.setString(14, skemp.getHkplace());
			pstmt.setString(15, skemp.getXl());
			pstmt.setString(16, skemp.getDegree());
			pstmt.setString(17, skemp.getGraduateschool());
			pstmt.setString(18, skemp.getProfessional());
			pstmt.setDate(19, skemp.getGraduatetime());
			pstmt.setString(20, skemp.getDpname());
			pstmt.setString(21, skemp.getJobname());
			pstmt.setInt(22, skemp.getId());
			pstmt.executeUpdate();
			System.out.println("111111111");
			
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
	public List<Skemp> getSkemps(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Skemp>  skemps=new ArrayList<Skemp>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from skemp where id=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Skemp skemp = new Skemp();
				skemp.setId(rs.getInt("id"));
				skemp.setName(rs.getString("name"));
				skemp.setSex(rs.getString("sex"));
				skemp.setBir(rs.getDate("bir"));
				skemp.setIdcard(rs.getString("idcard"));
				skemp.setToworktime(rs.getDate("toworktime"));
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
				skemps.add(skemp);
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

	@Override
	public List<Skemp> getSkempNewStaff(String time1, String time2, String name) {
		// TODO Auto-generated method stub
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				ResultSet rs=null;
				List<Skemp> skemps = new ArrayList<Skemp>();
				
				
				
				try {
					conn = DbUtils.getConnection();
					if(""==name)
					{
						String sql = "select id,dpname,jobname,name,sex,graduatetime,xl from skemp where graduatetime between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, time1);
						pstmt.setString(2, time2);
						rs = pstmt.executeQuery();
					}
					else{
						String sql = "select id,dpname,jobname,name,sex,graduatetime,xl from skemp where dpname = ? and graduatetime between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, name);
						pstmt.setString(2, time1);
						pstmt.setString(3, time2);
						rs = pstmt.executeQuery();
						}
					
					while(rs.next()){
						Skemp skemp = new Skemp();
						skemp.setId(rs.getInt("id"));
						skemp.setDpname(rs.getString("dpname"));
						skemp.setJobname(rs.getString("jobname"));
						skemp.setName(rs.getString("name"));
						skemp.setSex(rs.getString("sex"));
						skemp.setGraduatetime(rs.getDate("graduatetime"));
						skemp.setXl(rs.getString("xl"));
						skemps.add(skemp);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					DbUtils.closePreparedStatement(pstmt);
					DbUtils.closeResultSet(rs);
				}

				return skemps;
	}

	
	@Override
	public void updateSkChange(Skemp skempChange) {
		Connection conn=null;
		PreparedStatement pstmt=null;


		try {
			conn=DbUtils.getConnection();
			String sql="update skemp set dpid=?,jobid=?,dpname=?,jobname=? where id=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,skempChange.getDpid());
			pstmt.setInt(2,skempChange.getJobid());
			pstmt.setString(3,skempChange.getDpname());
			pstmt.setString(4,skempChange.getJobname());
			pstmt.setInt(5,skempChange.getId());
			
			/*System.out.println(skempChange.getDpid());
			System.out.println(skempChange.getJobid());
			System.out.println(skempChange.getDpname());
			System.out.println(skempChange.getJobname());
			System.out.println(skempChange.getId());*/
			
			pstmt.executeQuery();
			
			
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
	
	

}
