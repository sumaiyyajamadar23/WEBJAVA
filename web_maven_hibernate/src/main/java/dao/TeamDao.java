package dao;

import java.util.List;

import pojos.Team;

public interface TeamDao 
{
 String addTeam(Team teams);
 
  List<Team> getByAbbrv();//Hint constructor expression
  
  Team getTeamDetails(Long teamid);
  
}

