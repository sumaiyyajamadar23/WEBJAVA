package dao;

import pojos.Employee;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;
public class EmployeeDaoImp implements EmployeeDao 
{

	@Override
	public String insertEmpDetails(Employee emp) {
		String msg="add emp_details, failed!!!!!!!!!!!";
		// get session from session factory
		Session session=getFactory().openSession();//hibernet database pools out/takes out
		//wraps in session obj n returns it to caller
		//begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
			session.save(emp);
			//commit transaction
			tx.commit();
			msg="add emp_details"+emp.getEmpid();
		}
		catch(RuntimeException e)
		{
			//rollback tran
			if(tx!=null)
				tx.rollback();
			//re throw same exception to caller:to inform user/caller
			throw e;
		}
		finally
		{
			//session close
			if(session!=null)
			{
				session.close();//pooled out db cn simply returns to pool
			}
		}
		return msg;
	}

}
//boiler plat code :repeatative