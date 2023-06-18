package studTester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.*;
import dao.StudentDaoImp;
import pojos.*;
import pojos.Course;

import java.time.LocalDate;
import java.util.Scanner;

public class LoginStudent 
{
	public static void main(String[] args)
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))	
	{
		StudentDaoImp dao=new StudentDaoImp();
		System.out.println("Enter:- email,password");
	  System.out.println(dao.loginStudent(sc.next(), sc.next()));
	  System.out.println("login sucessfully!!!!");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
