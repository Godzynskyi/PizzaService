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
	<c:choose>
		<c:when test="${pizza.id ne null}">
			<h2>Congratulations, you've successfully persisted pizza with id= '${pizza.id}'.</h2>
		</c:when>
		<c:when test="${pizza.id eq null}">
			<h2>Sorry, something is going wrong. Pizza haven't been persisted.</h2>
		</c:when>
	</c:choose>

</body>
</html>