package studTester;
import org.hibernate.SessionFactory;
import dao.StudentDaoImp;
import pojos.Course;
import static utils.HibernateUtils.getFactory;
import java.util.Scanner;
public class ChangeCoursebyId {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in))
		
		{
			
			StudentDaoImp dao = new StudentDaoImp();
			System.out.println("Enter email , password n salary increment");
			System.out.println(dao.changeCourse(sc.nextInt(),Course.valueOf(sc.next())));

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
