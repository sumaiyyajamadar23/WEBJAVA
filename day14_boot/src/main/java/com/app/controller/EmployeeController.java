package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	//dependency:service layer i/f
	@Autowired
	private EmployeeService empService;
public EmployeeController() {
	System.out.println("in def constr of emp:" +getClass());
}
//URL:-http://localhost:8080/day14_boot/emp/list  method=post
//pyaLoad (req body):dept_id=1
//@RequestParam-annotation to bind incoming req parameter to 
//method argument,does parsing also...Match req param name with method arg name
//SC: Long dept_id=Long.parsLong(request.getParameter("dept_id")
@PostMapping("/list")
public String listEmpByDept(@RequestParam Long dept_id,Model map) 
{
System.out.println("in list emps by dept"+getClass());
map.addAttribute("emp_list",empService.getAllEmpsByDeptId(dept_id));
return "/emp/list";//AVN:/WEB-INF/views/emp/list.jsp
}
//http://host:port/day14_boot/emp/signin,method:GET
@GetMapping("/login")
public String showLoginForm()
{
	System.out.println("in show login form");
	return "/emp/login";//AVN: /WEB-INF/views/emp/login.jsp
}

//http://host:port/day14_boot/emp/signin,method:Post
@PostMapping("/login")
public String processLoginForm(@RequestParam String email,@RequestParam String password,Model map)
{
	System.out.println("in process login form"+email+""+password);
	Employee emp=empService.authenticate(email,password);
	if(emp!=null)
	{
		map.addAttribute("emp_details",empService.authenticate(email, password));
		return "/emp/details";
	}
	return "/emp/login";
	//AVN: /WEB-INF/views/emp/login.jsp
}

}
