package dao;

import java.sql.SQLException;

import pojos.User;

public interface Userdao 
{
	User authenticate(String email, String password) throws SQLException;
}
