package beans;

import java.sql.SQLException;
import java.util.List;

import dao.TeamDaoImpl;
import pojos.Team;

public class IplBeans
{
private TeamDaoImpl teamsD;

public IplBeans() throws SQLException 
{
	teamsD=new TeamDaoImpl();
	System.out.println("ipl bean created");
}

public TeamDaoImpl getTeamsD() {
	return teamsD;
}

public void setTeamsD(TeamDaoImpl teamsD) {
	this.teamsD = teamsD;
}
//add BL to return list of all teams to caller
public List<Team> getAllTeams() throws SQLException
{
	return teamsD.getSelectedDetails();
}

}
