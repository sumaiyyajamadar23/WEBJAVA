package dao;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;
import static utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addNewEmployee(Employee emp, long deptId) {
		String mesg = "adding emp failed!!!!!!!!!!!";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent dept from db
			Department dept = session.get(Department.class, deptId);
			if (dept != null) {
				// dept : PERSISTENT
//				// add emp ref to dept's AL
//				dept.getEmpList().add(emp);// parent ---> emp
//				// add dept ref to the emp
//				emp.setAssignedDept(dept); // child --> parent'
				dept.addEmployee(emp);
				// save emp rec
				// session.persist(emp); NO LONGER required : since cascade : ALL (includes
				// update)
				mesg = "Added new emp to Dept " + dept.getDepartmentName();
			}
			tx.commit(); // hib performs dirty chking -- finds state of dept updated -- finds new emp ref
							// in l1 cache --auto fires insert query w/o expilcitly add session.persist
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteEmpDetails(String deptName, String empEmail) {
		String mesg = "deleteing  emp details failed!!!!!!!!!!!";
		String deptJpql = "select d from Department d where d.departmentName=:nm";
		String empJqpl = "select e from Employee e where e.email=:em";
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			Department dept = session.createQuery(deptJpql, Department.class).setParameter("nm", deptName)
					.getSingleResult();
			Employee emp = session.createQuery(empJqpl, Employee.class).setParameter("em", empEmail).getSingleResult();
			// dept , emp : persistent
			dept.removeEmployee(emp);
			tx.commit();
			mesg = "Deleted emp details ....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public Employee getEmpDetails(long empId) {
		Employee emp = null;
		// 1 get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.get(Employee.class, empId); // persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return emp;// emp : (in case of valid id) : DETACHED
	}

	@Override
	public String storeImage(long empid, String path) throws IOException 
	{
		String msg="Storing failed";
	Session sess=getFactory().getCurrentSession();
	Transaction tx=sess.beginTransaction();
	try
	{
		Employee emp=sess.get(Employee.class,empid);
		if(emp!=null)
		{
			//emp persist
			//Wrapp the path int java.io.File(String path)
			File file=new File(path);
			//valid if file exists and read permission
			if(file.isFile() && file.canRead())
			{
				//readable existing file---->convert to byte[]
				// public static byte[] readFileToByteArray(File file) throws IOException
				//set image
				emp.setImage(FileUtils.readFileToByteArray(file));
				//convert file class instance to binary
				msg="Storing Successful";
			}
		}
		tx.commit();
		
	}
	catch(RuntimeException e)
	{
		if(tx!=null)
			tx.rollback();
		throw e;
	}
		return msg;
	}

	@Override
	public String restoreImage(long empid, String path) throws IOException
	{
		String msg="restoring image failed";
		Session sess=getFactory().getCurrentSession();
		Transaction tx=sess.beginTransaction();
		try
		{
			Employee emp=sess.get(Employee.class,empid);
			if(emp!=null)
			{
				//emp persist
				byte[] image=emp.getImage();
				if(image!=null) 
				{
					// public static void writeByteArrayToFile(File file, byte[] data)throws IOException//set image
					FileUtils.writeByteArrayToFile(new File(path),emp.getImage());
					msg="ReStoring Image Successful";
				}
			}
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
			return msg;
		}

}
