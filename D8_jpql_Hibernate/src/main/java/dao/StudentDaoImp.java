package dao;

import pojos.Student;
import static utils.HibernateUtils.*;

import java.io.Serializable;

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
	public String loginStudent(String email, String password) {
		String msg1="Login FAilde!!!!!!";
		
		return msg1;
	}

}
