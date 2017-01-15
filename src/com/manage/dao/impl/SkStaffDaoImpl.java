package com.manage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.manage.dao.SkStaffDao;
import com.manage.dao.domain.Skstaff;
import com.manage.utils.DbUtils;

public class SkStaffDaoImpl implements SkStaffDao{


	@Override
	public void insertSkStaff(Skstaff skstaff) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DbUtils.getConnection();
		//操作数据库
		
		String sql = "INSERT  INTO skstaff(empno,jobid,source) VALUES(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, skstaff.getEmpno());
			pstmt.setInt(2, skstaff.getJobid());
			pstmt.setString(3, skstaff.getSource());
		
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtils.closeConnection(conn);
			DbUtils.closePreparedStatement(pstmt);
		}
		
	}

	@Override
	public void updateSkStaff(Skstaff skstaff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSkStaff(Skstaff skstaff) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Skstaff> getSkStaffs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skstaff getSkStaffsById(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

}
