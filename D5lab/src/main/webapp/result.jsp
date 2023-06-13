<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
<h5>
Hello,${param.fn}{requestScope.stud_info.lname}
</h5>
 --%>
	<%
	Student s = (Student) request.getAttribute("stud_info");
	%>
	<h3>Hello,${param.fn} ${param.ln}</h3>
	<%
	if (s.isAdmitted()) {
	%>
	<h5 style="color: green;">Congratulations,You are admitted
		in,${requestScope.stud_info.selectedCourse}</h5>
	<%
	} else {
	%>
	<h5 style="color: red;">Sorry!!!,You are not admitted
		in,${requestScope.stud_info.selectedCourse}</h5>
	<!-- requestScope.stud_info returns refrence -->
	<%
	}
	%>

</body>
</html>