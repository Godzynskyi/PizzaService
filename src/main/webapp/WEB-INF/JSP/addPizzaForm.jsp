<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza Service - Adding Pizza</title>
</head>
<body>
	<form action="add" method="POST">
		Pizza Name: 
		<input type = "text" name = "name"/>
		<br>
		
		Pizza Description: 
		<input type = "text" name  = "description"/>
		<br>
		
		CheckName: 
		<input type = "text" name  = "checkName"/>
		<br>
		
		Price:
		<input type = "text" name = "price"/>
		<br>
		
		<c:forEach var="type" items="${PizzaTypes}">
			<input type="radio" name="type" value="${type}"/>${type} <br>
		</c:forEach>
		
		<input type="submit"/>
		
	</form>
</body>
</html>