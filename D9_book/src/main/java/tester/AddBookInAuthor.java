package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
import dao.BookDaoImp;
import pojos.Book;

import org.hibernate.SessionFactory;;
public class AddBookInAuthor 
{
	public static void main(String[] args) 
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))
	{
		BookDaoImp dao=new BookDaoImp();
		System.out.println("Enter: book title and price");
		Book book=new Book(sc.next(), sc.nextDouble());
		System.out.println("Enter author id");
		dao.addBook(book,sc.nextInt());
	}
	}

}
