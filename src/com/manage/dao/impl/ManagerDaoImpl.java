package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.MangerDao;
import com.manage.dao.domain.Manager;
import com.manage.utils.DbUtils;



public class ManagerDaoImpl implements MangerDao{

	@Override
	public void insertManager(Manager manager) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
				try {
					conn=DbUtils.getConnection();
					//3.操作数据库	
					String sql="insert into manager(id,name,pass,explanation1,explanation2,explanation3) values(?,?,?,?,?,?)";					
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, manager.getId());
					pstmt.setString(2,manager.getName());
					pstmt.setString(3,manager.getPass());
					pstmt.setString(4,manager.getExplanation1());
					pstmt.setString(5,manager.getExplanation2());
					pstmt.setString(6,manager.getExplanation3());
					
					pstmt.executeUpdate();
					
				}  catch (SQLException e) {
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
	public void updateManager(Manager manager) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;


		try {
			System.out.println("OK");
			conn=DbUtils.getConnection();
			String sql="update manager set name=?,pass=?,explanation1=?,explanation2=?,explanation3=? where id=?";
			System.out.println("OK");
			pstmt=conn.prepareStatement(sql);
			System.out.println("OK");
			pstmt.setString(1,manager.getName());
			pstmt.setString(2,manager.getPass());
			pstmt.setString(3,manager.getExplanation1());
			pstmt.setString(4,manager.getExplanation2());
			pstmt.setString(5,manager.getExplanation3());
			pstmt.setInt(6, manager.getId());
			System.out.println("OK");
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
	public void deleteManager(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {
			conn=DbUtils.getConnection();
			String sql="delete from manager where id=?";
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
	public List<Manager> getManagers(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Manager>  managers=new ArrayList<Manager>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from manager where id=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Manager manager=new Manager();
				manager.setId(rs.getInt("id"));//
				manager.setName(rs.getString("name"));
				manager.setPass(rs.getString("pass"));
				manager.setExplanation1(rs.getString("explanation1"));
				manager.setExplanation2(rs.getString("explanation2"));
				manager.setExplanation3(rs.getString("explanation3"));
				managers.add(manager);
				
			}
			System.out.println("OK");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
	    DbUtils.closeResultSet(rs);
		DbUtils.closePreparedStatement(pstmt);
		DbUtils.closeConnection(conn);
		
		}
		return managers;
	}

	@Override
	public Manager getManagerByDeptno(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Manager  manager=new Manager();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from manager where id=?";		
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				manager.setId(rs.getInt("id"));//
				manager.setName(rs.getString("name"));
				manager.setPass(rs.getString("pass"));
				manager.setExplanation1(rs.getString("explanation1"));
				manager.setExplanation2(rs.getString("explanation2"));
				manager.setExplanation3(rs.getString("explanation3"));
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
		return manager;
		
	}

	@Override
	public Manager loginManager(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Manager manager=new Manager();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select pass from manager where id=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				manager.setPass(rs.getString("pass"));
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
		return manager;
	}

}
