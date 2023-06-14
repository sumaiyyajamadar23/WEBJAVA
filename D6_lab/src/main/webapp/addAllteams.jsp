<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALL Team Detail</title>
</head>
<%--getServletContext().setAttribute("ipl",new IplBeans)--%>
<jsp:useBean id="ipl" class="beans.IplBeans" scope="application"/>
<body>
<%-- --%>
<h3>
Teams:${applicationScope.ipl.getAllTeams()}
</h3>

</body>
</html>