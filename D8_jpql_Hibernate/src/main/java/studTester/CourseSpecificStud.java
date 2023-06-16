package studTester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.*;
import dao.StudentDaoImp;
import pojos.*;
//import pojos.Course;

import java.time.LocalDate;
import java.util.Scanner;

public class CourseSpecificStud {

	public static void main(String[] args)
	{
			try(SessionFactory sf=getFactory();
					Scanner sc=new Scanner(System.in))	
			{
				StudentDaoImp dao=new StudentDaoImp();
				System.out.println("Enter:Course name to see all students");
				dao.getByCourse(sc.next()).forEach(System.out::println);

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}


	}
