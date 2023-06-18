package dao;

import pojos.Author;
import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class AuthorDaoImp implements AuthorDao 
{

	@Override
	public String addAuthor(Author auth) 
	{
		String msg="Failed";
		Session sess=getFactory().getCurrentSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			sess.persist(auth);
			tx.commit();
			msg = "added new Author with auto generated id=" + auth.getId();
		}
		catch(RuntimeException r)
		{
			tx.rollback();
		}
		return msg;
	}

}
