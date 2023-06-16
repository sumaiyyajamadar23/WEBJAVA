package dao;

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
	public String loginStudent(String email, String password)
	{
		String msg1="Login FAilde!!!!!!";
		
		return msg1;
	}

	@Override
	public List<Student> getByCourse(String coursetype) 
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

}
