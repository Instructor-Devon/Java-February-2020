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
			<h1>Welcome to Wedding Planner</h1>
			<a href="/logout">Logout</a>
			<a href="/weddings/new">Create Wedding</a>
			<hr />
			<table class="table table-dark table-hover">
				<thead>
					<tr>
						<th>Wedding</th>
						<th>Date</th>
						<th>Guests</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${ weddings }" var="wedding">
					<tr>
						<td><a href="/weddings/${ wedding.id }">${ wedding.bride } ${ wedding.groom }</a></td>
						<td>${ wedding.date }</td>
						<td>${ wedding.guests.size() }</td>
						<c:choose>
							<c:when test="${ wedding.planner.id == user.id }">
							<td><a href="#">DELETE</a></td>
							</c:when>
							<c:when test="${ wedding.guests.contains(user) }">
							<td><a href="#">Un-RSVP</a></td>
							</c:when>
							<c:otherwise>
							<td><a href="#">RSVP</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>