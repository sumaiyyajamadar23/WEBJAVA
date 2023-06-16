package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.*;
import dao.StudentDaoImp;
import pojos.*;
import pojos.Course;

import java.time.LocalDate;
import java.util.Scanner;

public class AddStud 
{
	public static void main(String[] args)
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))	
	{
		StudentDaoImp dao=new StudentDaoImp();
		System.out.println("Enter:-fname,  lname,  email,password,  course,  dob");
		Student newStud=new Student(sc.next(), sc.next(), sc.next(), sc.next(), Course.valueOf(sc.next()),LocalDate.parse(sc.next()));
		System.out.println(dao.insertStudent(newStud));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
