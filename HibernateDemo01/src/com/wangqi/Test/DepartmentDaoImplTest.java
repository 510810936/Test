package com.wangqi.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.wangqi.dao.DepartmentDao;
import com.wangqi.daoImpl.DepartmentDaoImpl;

public class DepartmentDaoImplTest {
	private DepartmentDao deptdao=null;
	@Before
	public void init(){
		deptdao = new DepartmentDaoImpl();
	}
	@Test
	public void testAddDepartment() {
		boolean addDepartment = deptdao.addDepartment();
		System.out.println(addDepartment);
	}

}
