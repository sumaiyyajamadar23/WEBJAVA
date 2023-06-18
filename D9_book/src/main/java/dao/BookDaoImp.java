package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import pojos.Author;
import pojos.Book;

public class BookDaoImp implements BookDao
{

	@Override
	public String addBook(Book b,int authid) 
	{
		Session sess=getFactory().getCurrentSession();
		Transaction t=sess.beginTransaction();
		try
		{
			Author auth=sess.get(Author.class,authid);
			auth.getBookList().add(b);
     		b.setSelectedAuth(auth); 
     		sess.persist(b);
			t.commit();
		}
		catch(RuntimeException r)
		{
			t.rollback();
		}
		
		return null;
	}

}
