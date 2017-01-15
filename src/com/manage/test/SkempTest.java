package com.manage.test;

import java.util.List;

import com.manage.dao.LeaveDao;
import com.manage.dao.SkempDao;
import com.manage.dao.domain.Leave;
import com.manage.dao.domain.Skemp;
import com.manage.dao.impl.LeaveDaoImpl;
import com.manage.dao.impl.SkempDaoImpl;

public class SkempTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testQuery();
		//testInsert();
		
	}

	private static void testInsert() {
		// TODO Auto-generated method stub
		Skemp skemp = new Skemp();
		skemp.setId(99);
		skemp.setName("王2");
		skemp.setSex("男");
		SkempDao skempDao = new SkempDaoImpl();
		skempDao.insertSkemp(skemp);
	}

	private static void testQuery() {
		// TODO Auto-generated method stub
		/*SkempDao skempDao = new SkempDaoImpl();
		List<Skemp> skemps = skempDao.getSkemps();
		for(Skemp sk:skemps){
			System.out.println(sk.getId() + "\t" + sk.getName() + "\t" + sk.getSex());
		}*/
		LeaveDao leaveDao = new LeaveDaoImpl();
		List<Leave> leaves = leaveDao.getLeaves();
		for(Leave le : leaves){
			System.out.println(le.getEmpno() + "\t" + le.getJobid() + "\t" + le.getTime());
		}
	}

}
