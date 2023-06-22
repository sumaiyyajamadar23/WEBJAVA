package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller // mandatory to tell spring container: following is request handling 
//controller=Handler,containg requ handling methods
public class HomepgaeController
{
public HomepgaeController()
{
	System.out.println("in constr of "+getClass());
}
//Add request handler method
@RequestMapping("/")//can intercept get/post/delete/put
public ModelAndView showHomePage()
{
	System.out.println("in show home page");
	//API o.s.w.s.ModelAndView(String ViewName,String ModelAttrName, Object value)
	return new ModelAndView("/index", "timestamp" , LocalDateTime.now());
	//Handler method return ModelAndView object to DispatcherServlet-->
	//-->sends logical view name(LVN) to ViewResolver-->
	//return AVN(actual view name):/WEB-INF/views/index.jsp-->DS
	//chcks for model attr.-->yes--> saves it under the req scope -->why>--> server pull
	//RD rd=request.getRD("/WEB-INF/views/index.jsp")
	//rd.forward(req,resp)-->jsp-->${..}
}
}
