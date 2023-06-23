package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
//add a method to get list of emps,by deptId
	 List<Employee> getAllEmpsByDeptId(Long deptId);

	Employee authenticate(String email, String password);
}
