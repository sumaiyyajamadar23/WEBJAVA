package tester;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImp;
import pojos.Employee;
import pojos.EmployeeType;

import static utils.HibernateUtils.*;

import java.time.LocalDate;
import java.util.Scanner;
public class TestHibernate 
{

	public static void main(String[] args)
	{
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in))//invoking static method-->
		//cls loading-->stattic initia blocks--configure:entire hib framework
		{
			EmployeeDaoImp dao=new EmployeeDaoImp();
				System.out.println("firstname, lastname,  email,  password,"
					+ "			 confirmpassword,  joindate,  type,  salary) ");
			Employee newEmp=new Employee(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()), EmployeeType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println(dao.insertEmpDetails(newEmp));
			//System.out.println("hib up n running!!!"+sf);
		}//sf.close()--->cleaning up DBCP
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
