<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<spring:url var="url" value="/emp/list"/>
	<form action="${url}" method="post">
			<table style="background-color: lightgrey; margin: auto">
			<caption>All employees</caption>
					<c:forEach var="emp" items="${requestScope.emp_list}">
						
				<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.email}</td>
				<td>${emp.joinDate}</td>
				</tr>
				</c:forEach>
				
			
			<tr>
				<td><input type="submit" value="Choose Department" /></td>
			</tr>

		</table>
	</form>
</body>
</html>