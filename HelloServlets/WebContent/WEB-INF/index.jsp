<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
<title>Insert title here</title>
</head>
<body>
	
	<h1>Hello ${ person.name } from ${ person.location }</h1>
	<a href="People">go to people</a>
</body>
</html>