package dao;

import java.io.IOException;

import pojos.Employee;

public interface EmployeeDao {
//add new emp
	String addNewEmployee(Employee emp, long deptId);

	// delete emp details
	String deleteEmpDetails(String deptName, String empEmail);

	Employee getEmpDetails(long nextLong);
	
	//adad method to Storing Employee image in database
	 String storeImage(long empid,String path) throws IOException;
	 //add method to restore image frim database
	 String restoreImage(long empid,String path) throws IOException;
}
