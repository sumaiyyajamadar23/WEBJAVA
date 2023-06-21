package tester;

import org.hibernate.SessionFactory;

import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Department;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class StoreEmployeeImage {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			EmployeeDao dao = new EmployeeDaoImpl();
			System.out.println("Enter emp id");
			long empId=sc.nextLong();
			System.out.println("Enter file name with path");
			System.out.println(dao.storeImage(empId, sc.next()));
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
