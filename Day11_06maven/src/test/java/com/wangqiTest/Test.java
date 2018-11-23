package com.wangqiTest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wangqi.Utils.HibernateUtil;
import com.wangqi.entity.Student;
import com.wangqi.entity.Teacher;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		
	/*	Object object = session.get(Student.class, 1);
		System.out.println(object);
		
		List<Student> list = session.createQuery("from Student where sname='zs'").list();
			for(Student stu:list) {
				for(Teacher teacher:stu.getTeachers()) {
					System.out.println(teacher);
				}
			}
		}*/
		Transaction	beginTransaction = session.beginTransaction();
		Student student1 = new Student("lili1","这","2");
		Student student2 = new Student("lili2","那","3");
		Teacher teacher = new Teacher("那位老师",11,"美术");
		try {
			student1.getTeachers().add(teacher);
			student2.getTeachers().add(teacher);
		//	Teacher tea = (Teacher) session.get(Teacher.class,"孙老师");
			teacher.getStudentTeachers().add(student1);
			teacher.getStudentTeachers().add(student2);
			session.save(student1);
			session.save(student2);
			session.save(teacher);
			
			
			beginTransaction.commit();
		}catch(Exception e) {
			beginTransaction.rollback();
		}finally {
			session.close();
		}
		
		
		
	}
		
}
	

