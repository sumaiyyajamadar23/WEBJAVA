package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service  //mandatory annotation to tell sc,following is spring bean:Containing BL
@Transactional //os mandatory annotation to tell spring container 
               //to manage transaction automatically
public class DepartmentServiceImp implements DepartmentService
{
	//dependency:dao layer interface
     @Autowired//by type:field lvl DI
     private DepartmentDao deptDao;
	@Override
	public List<Department> getallDepartments() {
		
		return deptDao.getallDepartmentDetails();
	}

}
