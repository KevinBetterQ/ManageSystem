package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.DepartmentDao;
import com.manage.dao.domain.Department;
import com.manage.utils.DbUtils;




public class DepartmentDaoImpl implements DepartmentDao{
	
	
	@Override
	public List<Department> selectDepartment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertDepartment(Department depart) {

		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=DbUtils.getConnection();
		//3.操作数据库	
		String sql="insert into  skdept(id,name,type,tele,fax,discrip,createtime) values(?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'))";					
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,depart.getId() );
			pstmt.setString(2, depart.getName());
			pstmt.setString(3,depart.getType());
			pstmt.setInt(4, depart.getTele());
			pstmt.setString(5, depart.getFax());
			pstmt.setString(6, depart.getDiscrip());
			pstmt.setString(7, depart.getCreatetime());	
			
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
	public void updateDepartment(Department depart) {
		
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try {

			conn=DbUtils.getConnection();
			
			String sql="update skdept set name=?,type=?,tele=?,fax=?,discrip=?,createtime=to_date(?,'yyyy-mm-dd') where id=?";
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, depart.getName());
			pstmt.setString(2,depart.getType());
			pstmt.setInt(3, depart.getTele());
			pstmt.setString(4, depart.getFax());
			pstmt.setString(5, depart.getDiscrip());
			pstmt.setString(6, depart.getCreatetime());	
			pstmt.setInt(7,depart.getId());
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
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=DbUtils.getConnection();
		
		String sql="delete from skdept where id=?";
		
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
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Department>  depts=new ArrayList<Department>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from skdept";			
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Department depart=new Department();
				depart.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//
				depart.setName(rs.getString("name"));//(rs.getString("ENAME"));
				depart.setType(rs.getString("type"));//(rs.getString("JOB"));
				depart.setTele(rs.getInt("tele"));
				depart.setFax(rs.getString("fax"));
				depart.setDiscrip(rs.getString("discrip"));
				depart.setCreatetime(rs.getString("createtime"));
				//System.out.println("ffff:"+depart.getId());
				depts.add(depart);
				
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
		return depts;
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Department department=new Department();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			String sql="select * from skdept where id=?";			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				department.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//
				department.setName(rs.getString("name"));//(rs.getString("ENAME"));
				department.setType(rs.getString("type"));//(rs.getString("JOB"));
				department.setTele(rs.getInt("tele"));
				department.setFax(rs.getString("fax"));
				department.setDiscrip(rs.getString("discrip"));
				department.setCreatetime(rs.getString("createtime"));
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
		return department;
	}

	@Override
	public List<Department> getDepartmentstaff(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Department>  depts=new ArrayList<Department>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			//String sql="select sk.id,sk.name,so.id,so.name from skdept sk，skemp so where so.dpid='id'";			
			String sql="select id,name,dpid,dpname,tele,jobid,jobname from skemp where dpid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Department depart=new Department();
				depart.setId(rs.getInt("id"));//(rs.getInt("EMPNO"));//员工编号
				depart.setName(rs.getString("name"));//(rs.getString("ENAME"));员工姓名
				depart.setId(rs.getInt("dpid"));//(rs.getString("JOB"));部门编号
				depart.setType(rs.getString("dpname"));//部门姓名
				//depart.setFax(rs.getString("fax"));//职务
				//System.out.println(rs.getString("tele"));
				//depart.setTele(Integer.valueOf(rs.getString("tele")));//depart.setDiscrip(rs.getString("discrip"));//联系电话
				depart.setJobid(rs.getInt("jobid"));//depart.setCreatetime(rs.getString("createtime"));//岗位编号
				depart.setJobname(rs.getString("jobname"));//System.out.println("ffff:"+depart.getId());//岗位名称
				//入职时间
				//人数总计
				depts.add(depart);
				
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
		return depts;
	}
	

}
