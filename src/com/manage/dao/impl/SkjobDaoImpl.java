package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.SkjobDao;
import com.manage.dao.domain.Skjob;
import com.manage.utils.DbUtils;


public class SkjobDaoImpl implements SkjobDao{

	@Override
	public void selectSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=DbUtils.getConnection();
		//3.操作数据库	
		String sql="insert into  skjob(id,name,type,limit,deptno) values(?,?,?,?,?)";					
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,skjob.getId() );
			pstmt.setString(2, skjob.getName());
			pstmt.setString(3,skjob.getType());
			pstmt.setInt(4, skjob.getLimit());
			pstmt.setInt(5, skjob.getDeptno());
			//pstmt.setString(6, depart.getDiscrip());
			//pstmt.setString(7, depart.getCreatetime());	
			
			int i=pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//4.关闭数据库		
		DbUtils.closePreparedStatement(pstmt);
		DbUtils.closeConnection(conn);
	}

	@Override
	public void updateSkjob(Skjob skjob) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {

			conn=DbUtils.getConnection();
			
			String sql="update skjob set name=?,type=?,limit=?,deptno=? where id=?";
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, skjob.getName());
			pstmt.setString(2,skjob.getType());
			pstmt.setInt(3, skjob.getLimit());
			pstmt.setInt(4, skjob.getDeptno());	
			pstmt.setInt(5,skjob.getId());
			int i=pstmt.executeUpdate();
			System.out.println(i);
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
	public void deleteSkjob(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=DbUtils.getConnection();
		
		String sql="delete from skjob where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
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
	public List<Skjob> getSkjobs() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Skjob>  skjobs=new ArrayList<Skjob>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from skjob";			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Skjob skjob=new Skjob();
				skjob.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//
				skjob.setName(rs.getString("name"));//(rs.getString("ENAME"));
				skjob.setType(rs.getString("type"));//(rs.getString("JOB"));
				skjob.setLimit(rs.getInt("limit"));
				skjob.setDeptno(rs.getInt("deptno"));
				//System.out.println("ffff:"+depart.getId());
				skjobs.add(skjob);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
	    DbUtils.closeResultSet(rs);
	    DbUtils.closePreparedStatement(pstmt);
	    DbUtils.closeConnection(conn);
		
		}
		return skjobs;
	}

	@Override
	public Skjob getSkjobById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Skjob skjob=new Skjob();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from skjob where id=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				skjob.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//
				skjob.setName(rs.getString("name"));//(rs.getString("ENAME"));
				skjob.setType(rs.getString("type"));//(rs.getString("JOB"));
				skjob.setLimit(rs.getInt("limit"));
				skjob.setDeptno(rs.getInt("deptno"));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		}
		return skjob;
	}

	@Override
	public List<Skjob> getSkjobstaff(int id){
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Skjob>  skjobs=new ArrayList<Skjob>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			//String sql="select sk.id,sk.name,so.id,so.name from skdept sk，skemp so where so.dpid='id'";			
			String sql="select id,name，tele from skemp where jobid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Skjob skjob=new Skjob();
				skjob.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//员工编号
				skjob.setName(rs.getString("name"));//(rs.getString("ENAME"));员工姓名
				//depart.setId(rs.getInt("dpid"));//(rs.getString("JOB"));部门编号
				//depart.setType(rs.getString("dpname"));//部门姓名
				//depart.setFax(rs.getString("fax"));//职务
				skjob.setType(rs.getString("tele"));//depart.setDiscrip(rs.getString("discrip"));//联系电话
				//depart.setJobid(rs.getInt("jobid"));//depart.setCreatetime(rs.getString("createtime"));//岗位编号
				//depart.setJobname(rs.getString("jobname"));//System.out.println("ffff:"+depart.getId());//岗位名称
				//入职时间
				//人数总计
				skjobs.add(skjob);
				
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DbUtils.closeResultSet(rs);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeConnection(conn);
		
		}
		return skjobs;
	}
	
	}
	
