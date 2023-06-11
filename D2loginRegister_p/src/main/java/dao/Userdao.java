package dao;

import java.sql.SQLException;

import pojos.User;

public interface Userdao 
{
	User authenticate(String email, String password) throws SQLException;
	int register(String first_name,String Last_name,String email,String password,String dob) throws SQLException;
}
