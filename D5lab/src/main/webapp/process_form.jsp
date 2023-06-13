<%@page import="pojos.Student"%>
<%@page import="pojos.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>From process form page//will not display</h4>
<!--out.flush();  -->
<!-- response commited will throw exception illegal -->
<%String fname=request.getParameter("fn");
String lname=request.getParameter("ln"); 
int score=Integer.parseInt(request.getParameter("score")); 
Course c=Course.valueOf(request.getParameter("course").toUpperCase());
//firstName, String lastName, int score, Course selectedCourse
Student s1=new Student(fname,lname,score,c);
if(score>c.getMinScore())
	s1.setAdmitted(true);
request.setAttribute("stud_info", s1);
RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
rd.forward(request, response);
System.out.print("exec controll came back.....");
%>
</body>
</html>