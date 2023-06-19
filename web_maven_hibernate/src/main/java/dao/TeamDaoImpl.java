package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;
import static utils.HibernateUtils.*;
public class TeamDaoImpl implements TeamDao
{

	@Override
	public String addTeam(Team teams) {
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String msg="team not added!!!!!!1";
		try
		{
			
			session.persist(teams);
			
		tx.commit();	
		msg="team added successfully";
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
