package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;
import static utils.HibernateUtils.*;

import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeam(Team teams) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String msg = "team not added!!!!!!1";
		try {

			session.persist(teams);

			tx.commit();
			msg = "team added successfully";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getByAbbrv() {
		List<Team> teams = null;
		String jpql = "select new pojos.Team(id,abbrevation) from Team";
		Session sess = getFactory().getCurrentSession();

		Transaction tx = sess.beginTransaction();
		try {
			teams = sess.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException r) {
			r.printStackTrace();
			tx.rollback();
			throw r;
		}
		return teams;
	}

	@Override
	public Team getTeamDetails(Long teamid)
	{
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String msg = "team retrieved";
		Team t=null;
		try {
              t=session.get(Team.class, teamid);
			
			tx.commit();
			msg = "team added successfully";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return t;
	}

}
