package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
@Repository //mandatory annno to tells SC following is spring beans containing 
            //data access logic
public class DepartmentDaoImp implements DepartmentDao 
{
	//dependendency:Session Factory
    @Autowired//mandatory dependency:required=true,field lvl dependency injec
    private SessionFactory sf;//automatically supplied by spring supplied 
                          // :LocalSessionFactoryBean
	@Override
	public List<Department> getallDepartmentDetails() 
	{
	
		return sf.getCurrentSession()
				.createQuery("select d from Department d",Department.class)
				.getResultList();
	}

}
