package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;
import dao.EmployeeDaoImpl;
import pojos.EmploymentType;

import java.util.Scanner;
public class DeleteByType {

	public static void main(String[] args)
	
	{
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in))
	{
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		System.out.println("Enter type of Employees");
		System.out.println("Deleted:"+dao.deleteByType(EmploymentType.valueOf(sc.next())));
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	}

}
