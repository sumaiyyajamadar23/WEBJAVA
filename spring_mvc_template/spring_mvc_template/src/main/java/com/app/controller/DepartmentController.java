package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;
@Controller
@RequestMapping("/")//optional but rec: this SB will handle all dept related reqs 
public class DepartmentController {

	//dependency:service layer i/f
	@Autowired
	private DepartmentService deptService;
	public DepartmentController() {
		System.out.println("in constr of "+getClass());
	}

 @GetMapping("/list")
 public ModelAndView getDeptList()
 {
	 System.out.println("in get dept list");
	return new ModelAndView("/dept/list","dept_list",deptService.getallDepartments());
	 // dept:name of folder under web-inf folder
	//controller--MnV--DS--LVN--VR-->
	//AVN:             --ds checks for model
	//---yes---
}
}