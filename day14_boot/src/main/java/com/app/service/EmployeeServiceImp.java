
package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{
@Autowired
private EmployeeDao empDao;
	@Override
	public List<Employee> getAllEmpsByDeptId(Long deptId) 
	{
		System.out.println("on get all emp by deptId");
		
		return empDao.findByAssignedDeptId(deptId);
	}
	@Override
	public Employee authenticate(String email, String password)
	{
		
		return empDao.findByEmailAndPassword(email,password);
	}

}
