package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.dao.LeaveDao;
import com.manage.dao.domain.Leave;
import com.manage.dao.domain.Skemp;
import com.manage.utils.DbUtils;

import oracle.net.aso.l;

public class LeaveDaoImpl implements LeaveDao{

	@Override
	public void insertLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLeave(Leave leave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Leave> getLeaves() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs=null;
		List<Leave> leaves = new ArrayList<Leave>();
		
		String sql = "select * from leave";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Leave leave = new Leave();
				leave.setEmpno(rs.getInt("empno"));
				leave.setJobid(rs.getString("jobid"));
				leave.setTime(rs.getDate("time"));
				leaves.add(leave);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeResultSet(rs);
		}

		return leaves;
	}

	@Override
	public Leave getLeavesById(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		ResultSet rs=null;
		Leave leave = new Leave();
		
		
		String sql = "select * from leave where empno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			while(rs.next()){
				leave.setEmpno(rs.getInt("empno"));
				leave.setJobid(rs.getString("jobid"));
				leave.setTime(rs.getDate("time"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
			DbUtils.closeResultSet(rs);
		}

		return leave;
	}

}
