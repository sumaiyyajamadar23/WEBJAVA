package dao;

import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Teams;

public class TeamDaoimp implements TeamDao
{

	public Connection cn;
	public PreparedStatement pst1;
	public TeamDaoimp() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("select team_id,abbrevation from teams");
	}
	
	@Override
	public List<Teams> getSelectedDetails() throws SQLException 
	{
		List<Teams> teams=new ArrayList<>();
		try(ResultSet rs=pst1.executeQuery())
		{
			while(rs.next())
			{
				teams.add(new Teams(rs.getInt(1),rs.getString(2)));
			}
			return teams;
		}

	}
	public void cleanup() throws SQLException
	{
		if(pst1!=null)
		{
			pst1.close();
		
		}
	}

}
