<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:logreg>
	<div class="log-reg">
		<div>
			<h2>Login</h2>
			<p>${ loginError }</p>
			<form method="POST" action="/login">
				<div class="form-group">
			    	<label>Email:</label>
			    	<input class="form-control" type="email" name="email">
			    </div>
			    <div class="form-group">
			    	<label>Password:</label>
			    	<input class="form-control" type="password" name="password">
			    </div>
			    <button class="btn btn-danger">Login</button>
			</form>
		</div>
		<div>
			<h2>Register</h2>
			<form:form action="/" method="post" modelAttribute="user">
			    <div class="form-group">
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
			    </div>
			    <div class="form-group">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-group">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group">
			        <form:label path="confirmPassword">Confirm Password</form:label>
			        <form:errors path="confirmPassword"/>
			       <form:input type="confirmPassword" class="form-control" path="confirmPassword"/>
			    </div>
			    <input class="btn btn-danger" type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</t:logreg>