<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Dogs App!</title>
</head>
<body>
	<h1>Welcome to Dogs Dot Com!</h1>
	<hr />
	<a href="/new">Create a new Dog!</a>
	<h2>All Of Our Dogs!</h2>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Breed</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ dogs }" var="dog">
			<tr>
				<td>${ dog.id }</td>
				<td><a href="/${ dog.id }">${ dog.name }</a></td>
				<td>${ dog.breed }</td>
				<td>${ dog.description }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>