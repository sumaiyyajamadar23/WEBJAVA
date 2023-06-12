package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils 
{
	public static Connection cn;
public static Connection openConnection() throws SQLException
{
	String url="jdbc:mysql://localhost:3306/sumaiyya?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
	cn=DriverManager.getConnection(url,"root","Pass@");
	System.out.println("Connection Established......");
	return cn;
}

public static void closeConnection() throws SQLException
{
	if(cn!=null)
	{
		cn.close();
		System.out.println("Connection closed......");
	}
}
}
