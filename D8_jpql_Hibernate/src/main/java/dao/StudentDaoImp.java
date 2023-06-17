package dao;

import pojos.Course;
import pojos.Student;
import static utils.HibernateUtils.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class StudentDaoImp implements StudentDao {

	@Override
	public String insertStudent(Student stud)
	{
		String msg="Student register failllllll";
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
		Serializable id=session.save(stud);
		tx.commit();
		msg="sucessfullllll"+id;
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
		       tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public Student loginStudent(String email, String pass)
	{
		Student std=null;
		String jpql="select s from Student s where s.email=:em and s.password=:pass1";
		Session sess=getFactory().getCurrentSession();
		Transaction tx=sess.beginTransaction();
		try
		{
		std=sess.createQuery(jpql,Student.class).setParameter("em",email).setParameter("pass1",pass).getSingleResult();
		tx.commit();	
		}
		catch(RuntimeException r)
		{
			if(tx!=null)
	        	tx.rollback();
			throw r;
		}
		return std;
	}

	@Override
	public List<Student> getByCourse(Course coursetype) 
	{
		List<Student> list=null;
		String jpql="select s from Student s where s.course=: c";
		Session session = getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try
		{
		list=session.createQuery(jpql,Student.class)
				.setParameter("c",coursetype)
				.getResultList();
		tx.commit();
		
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
		       tx.rollback();
			throw e;
		}
		
		return list;
		
	}

	@Override
	public String changeCourse(int id, Course course)
	{
		Student std=null;
		String msg="invalid idDDDD!!!!!!!!!!!";
		String jpql="select s from Student s where s.id=:i";
		Session sess=getFactory().getCurrentSession();
		Transaction tx=sess.beginTransaction();
	try
	{
	     std=sess.createQuery(jpql,Student.class).setParameter("i",id).getSingleResult();
	     std.setCourse(course);
		tx.commit();
		msg=" course Updatedddd!!!!!!!!!!!!!";
	}
	catch(RuntimeException e)
	{
	tx.rollback();	
	}
		return msg;
	}

}
