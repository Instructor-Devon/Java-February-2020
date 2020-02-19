<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Wedding Planner</title>
</head>
	<body>
		<div class="container">
			<h1>${ wedding.bride } and ${ wedding.groom }'s Wedding</h1>
			<a href="/weddings">Dashboard</a>
			<a href="/logout">Logout</a>
			<hr />
			<h3>Date: ${ wedding.date }</h3>
			<h3>Address: ${ wedding.address }</h3>
			<h3>Guests<c:if test="${ wedding.guests.size() < 1 }">: NONE</c:if></h3>
			<ul>
			<c:forEach items="${ wedding.guests }" var="guest">
				<li>${ guest.firstName } ${ guest.lastName }</li>			
			</c:forEach>
			</ul>
		</div>
	</body>
</html>