package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.DBUtils.*;
import pojos.User;

public class Userdaoimp implements Userdao
{
	public Connection cn;
	public PreparedStatement pst1,pst2;
	
	public Userdaoimp() throws SQLException
	{
		cn=openConnection();
		pst1=cn.prepareStatement("Select * from users where email=? and password=?");
		pst2=cn.prepareStatement("insert into users values(default,?,?,?,?,?,0,'voter')");
		System.out.println("User dao created....");
	}

	@Override
	public User authenticate(String email, String password) throws SQLException 
	{
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rs=pst1.executeQuery())
		{
			if(rs.next())
			{
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3), email, password,rs.getDate(6),rs.getBoolean(7),rs.getString(8));
			}
			return null;
		}
	
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1!=null)
		{
          pst1.close();
          closeConnection();
          System.out.println("user dao cleanup......");
		}
	}

	@Override
	public int register(String first_name, String last_name, String email, String password, String dob) throws SQLException
	{
		pst2.setString(1, first_name);
		pst2.setString(2, last_name);
		pst2.setString(3, email);
		pst2.setString(4, password);
		pst2.setString(5, dob);
		int res=pst2.executeUpdate();
		
		return res;
	}

}
