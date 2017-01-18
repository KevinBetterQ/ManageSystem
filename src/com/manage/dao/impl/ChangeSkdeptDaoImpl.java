package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.ChangeSkdeptDao;
import com.manage.dao.domain.ChangeSkdept;
import com.manage.utils.DbUtils;



public class ChangeSkdeptDaoImpl implements ChangeSkdeptDao{

	@Override
	public List<ChangeSkdept> getChangeSkdepts(String time1, String time2) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ChangeSkdept>  changeSkdepts=new ArrayList<ChangeSkdept>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			//String sql="select sk.id,sk.name,so.id,so.name from skdept sk，skemp so where so.dpid='id'";			
			String sql="select c.olddept,c.newdept,s.name,s.sex,c.depttime,c.deptreason,c.deptype from skemp s,change c where s.id=c.id and c.depttime between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, time1);
			pstmt.setString(2, time2);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ChangeSkdept changeSkdept=new ChangeSkdept();
				changeSkdept.setOlddept(rs.getString("olddept"));//原部门
				changeSkdept.setNewdept(rs.getString("newdept"));//新部门
				changeSkdept.setName(rs.getString("name"));//姓名
				changeSkdept.setSex(rs.getString("sex"));//性别
				changeSkdept.setDepttime(rs.getString("depttime"));//调动日期
				changeSkdept.setTime(rs.getString("deptreason"));//调动原因
				changeSkdept.setDeptype(rs.getString("deptype"));
				//changeSkdept.setJobid(rs.getInt("jobid"));//depart.setCreatetime(rs.getString("createtime"));//岗位编号
				//changeSkdept.setJobname(rs.getString("jobname"));//System.out.println("ffff:"+depart.getId());//岗位名称
				//入职时间
				//人数总计
				changeSkdepts.add(changeSkdept);
				
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
		
		return changeSkdepts;
	}

	@Override
	public List<ChangeSkdept> getChangeSkjobs(String time1, String time2) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ChangeSkdept>  changeSkdepts=new ArrayList<ChangeSkdept>();
		try {
			conn=DbUtils.getConnection();
			//3.操作数据库			
			//String sql="select sk.id,sk.name,so.id,so.name from skdept sk，skemp so where so.dpid='id'";			
			String sql="select c.oldjob,c.newjob,s.name,s.sex,c.jobtime,c.time,c.type from skemp s,change c where s.id=c.id and c.depttime between to_date(?,'yyyy-mm-dd') and to_date(?,'yyyy-mm-dd')";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, time1);
			pstmt.setString(2, time2);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ChangeSkdept changeSkdept=new ChangeSkdept();
				//changeSkdept.setId(rs.getInt("id"));
				changeSkdept.setOlddept(rs.getString("oldjob"));//原部门
				changeSkdept.setNewdept(rs.getString("newjob"));//新部门
				changeSkdept.setName(rs.getString("name"));//姓名
				changeSkdept.setSex(rs.getString("sex"));//性别
				changeSkdept.setDepttime(rs.getString("jobtime"));//调动日期
				changeSkdept.setTime(rs.getString("time"));//调动原因
				changeSkdept.setType(rs.getString("type"));//岗位调转类型
				//changeSkdept.setJobid(rs.getInt("jobid"));//depart.setCreatetime(rs.getString("createtime"));//岗位编号
				//changeSkdept.setJobname(rs.getString("jobname"));//System.out.println("ffff:"+depart.getId());//岗位名称
				//入职时间
				//人数总计
				changeSkdepts.add(changeSkdept);
				
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
		
		return changeSkdepts;
	}
	
	public List<ChangeSkdept> getChangeSkemp(int id) {
		
				Connection conn=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				List<ChangeSkdept>  changeSkdepts=new ArrayList<ChangeSkdept>();
				try {
					conn=DbUtils.getConnection();
					//3.操作数据库			
					//String sql="select sk.id,sk.name,so.id,so.name from skdept sk，skemp so where so.dpid='id'";			
					String sql="select c.olddept,c.newdept,s.name,s.sex,c.depttime,c.deptreason from skemp s,change c where s.id=? and s.id=c.id";
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					rs=pstmt.executeQuery();
					
					while(rs.next())
					{
						ChangeSkdept changeSkdept=new ChangeSkdept();
						changeSkdept.setOlddept(rs.getString("olddept"));//原部门
						changeSkdept.setNewdept(rs.getString("newdept"));//新部门
						changeSkdept.setName(rs.getString("name"));//姓名
						changeSkdept.setSex(rs.getString("sex"));//性别
						changeSkdept.setDepttime(rs.getString("depttime"));//调动日期
						changeSkdept.setTime(rs.getString("deptreason"));//调动原因
						//changeSkdept.setJobid(rs.getInt("jobid"));//depart.setCreatetime(rs.getString("createtime"));//岗位编号
						//changeSkdept.setJobname(rs.getString("jobname"));//System.out.println("ffff:"+depart.getId());//岗位名称
						//入职时间
						//人数总计
						changeSkdepts.add(changeSkdept);
						
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
				
				return changeSkdepts;
	}

	
	@Override
	public void insertChange(ChangeSkdept changeSkdept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		//操作数据库
		
		String sql = "INSERT  INTO change(id,olddept,newdept,deptype,oldjob,newjob,type,jobtime) VALUES(?,?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'))";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, changeSkdept.getId());
			pstmt.setString(2, changeSkdept.getOlddept());
			pstmt.setString(3,changeSkdept.getNewdept() );
			pstmt.setString(4, changeSkdept.getDeptype() );
			pstmt.setString(5, changeSkdept.getOldjob());
			pstmt.setString(6, changeSkdept.getNewjob());
			pstmt.setString(7, changeSkdept.getType() );
			pstmt.setString(8, changeSkdept.getJobtime() );
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
		}
		
	}

}
