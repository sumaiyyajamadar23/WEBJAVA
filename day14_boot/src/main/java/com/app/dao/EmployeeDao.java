package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long>
{//derived(by Spring Data JPA) finder method//findBy/getBy-keyword,AssignedDept-property,Id-baseEntity property
	List<Employee> findByAssignedDeptId(Long deptId);

	Employee findByEmailAndPassword(String email, String password);

}
