package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
import dao.AuthorDaoImp;
import pojos.Author;

import org.hibernate.SessionFactory;

public class AddAuthor 
{
	public static void main(String[] args) 
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))
	{
      AuthorDaoImp dao=new AuthorDaoImp();
      System.out.println("Enter:FirstName,LastName,Email,Password");
      System.out.println(dao.addAuthor(new Author(sc.next(), sc.next(), sc.next(), sc.next())));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
