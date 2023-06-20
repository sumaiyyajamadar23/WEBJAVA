package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import pojos.Team;
import utils.HibernateUtils;

class TestTeamDao 
{
private static TeamDao dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		//build sf n create dao instance
	HibernateUtils.getFactory();//trigger creation of sf
	dao=new TeamDaoImpl();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception
	{
		HibernateUtils.getFactory().close();
	}

	@Test
	void test() 
	{
		//create Team instance
		Team team=new Team("qwe1","qwe11","qwe12",35,55,25);
		String msg=dao.addTeam(team);
		System.out.println(msg);
		assertEquals(8,team.getId());
	}
	@Test
	void testGetAllTeams()
	{
		System.out.println("hiii");
		List<Team> team=dao.getByAbbrv();
		team.forEach(e->System.out.println(e.getId()+""+e.getAbbrevation()));
		assertEquals(5,team.size());
	}

}
