package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;

//open cn
	public static Connection openConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/sumaiyya?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(dbURL, "root", "Pass@");
		System.out.println("db cn established....");
		return cn;
	}

//close cn
	public static void closeConnection() throws SQLException{
		if(cn != null)
			cn.close();
		System.out.println("db cn closed....");
	}
}
