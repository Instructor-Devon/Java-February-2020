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
			<h2>Create Wedding</h2>
			<form:form action="/weddings" method="post" modelAttribute="wedding">
				<form:input type="hidden" value="${ userId }" path="planner" />
			 	<div class="form-group">
			        <form:label path="bride">Bride Name</form:label>
			        <form:errors path="bride"/>
			        <form:input class="form-control" path="bride" />
			    </div>
			    <div class="form-group">
			        <form:label path="groom">Groom Name</form:label>
			        <form:errors path="groom"/>
			        <form:input class="form-control" path="groom" />
			    </div>
			    <div class="form-group">
			        <form:label path="date">Date</form:label>
			        <form:errors path="date"/>
			        <form:input type="date" class="form-control" path="date" />
			    </div>
			    <div class="form-group">
			        <form:label path="address">Address</form:label>
			        <form:errors path="address"/>
			        <form:input class="form-control" path="address" />
			    </div>
			    <button>Submit</button>
			</form:form>
		</div>
	</body>
</html>