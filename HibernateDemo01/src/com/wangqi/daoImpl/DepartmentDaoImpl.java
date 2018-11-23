package com.wangqi.daoImpl;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wangqi.Utils.HibernateUtil;
import com.wangqi.dao.DepartmentDao;
import com.wangqi.entity.Department;
import com.wangqi.entity.Employee;

public class DepartmentDaoImpl implements DepartmentDao {
	@Override
	public boolean addDepartment() {
		boolean flag=false;
		Session session=null;
		Transaction beginTransaction=null;
		try {
			session = HibernateUtil.getSession();
			beginTransaction = session.beginTransaction();
			Department dept = new Department("研发一部");
			
			Employee emp1 =new Employee("阿大");		
			Employee emp2 =new Employee("阿二");
			Employee emp3 =new Employee("阿三");
			emp1.setDepartment(dept);
			emp2.setDepartment(dept);
			emp3.setDepartment(dept);
			
			dept.getEmployees().add(emp1);
			dept.getEmployees().add(emp2);
			dept.getEmployees().add(emp3);
			
			session.save(dept);
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			flag=true;
			beginTransaction.commit();
		}catch(Exception e){
			flag=false;
			beginTransaction.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return flag;
		
	}

}
