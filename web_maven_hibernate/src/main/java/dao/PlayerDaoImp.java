package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.*;
import pojos.Player;
import pojos.Team;

public class PlayerDaoImp implements PlayerDao
{

	@Override
	public String addPlayerToTeam(Player newplayer, Long teamid) 
	{
		String msg="Addition failde";
	Session sess=getFactory().getCurrentSession();
	Transaction tx=sess.beginTransaction();
	try
	{
		Team team=sess.get(Team.class,teamid);
		if(team!=null) 
		{
			team.addPlayer(newplayer);
			msg="Player added to team";
		}
		tx.commit();
		
	}
	catch(RuntimeException r)
	{
		tx.rollback();
	}
		return null;
	}

}
