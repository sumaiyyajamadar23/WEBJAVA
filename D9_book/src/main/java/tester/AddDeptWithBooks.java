package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.AuthorDaoImp;
import pojos.Author;
import pojos.Book;
public class AddDeptWithBooks {

	public static void main(String[] args) 
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))
	{
		AuthorDaoImp dao=new AuthorDaoImp();
		System.out.println("Enter Department Details:fname,lname,email,pass");
		Author auth=new Author(sc.next(), sc.next(), sc.next(), sc.next());
		for(int i=0;i<3;i++)
		{
			System.out.println("Enter Book Detail:title & price");
			Book book=new Book(sc.next(),sc.nextDouble());
			auth.addook(book);
		}
		System.out.println(dao.addAuthor(auth));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}

}
