<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>Name:</h2>
	<p>${ dog.name }</p>
	<h2>Breed:</h2>
	<p>${ dog.breed }</p>
	<c:choose>
		<c:when test="${ dog.tag != null }">
		<h2>City:</h2>
		<p>${ dog.tag.city }</p>
		<h2>State:</h2>
		<p>${ dog.tag.state }</p>
		</c:when>
		<c:otherwise>
			<h3>Register this Dog!</h3>
			<form:form action="/tag" method="post" modelAttribute="tag">
				<form:hidden path="dog" value="${ dog.id }" />
				<div class="form-group">
					<form:label path="city">City</form:label>
					<form:errors path="city"/>
					<form:input path="city"/>
				</div>
				<div class="form-group">
					<form:label path="state">State</form:label>
					<form:errors path="state"/>
					<form:input path="state"/>
				</div>
				<button>Submit</button>
			</form:form>
		</c:otherwise>
	</c:choose>
	<hr />
	<h3>Edit This Dog</h3>
	<form:form action="/${ dog.id }" method="post" modelAttribute="dog">
		 <input type="hidden" name="_method" value="put">
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div class="form-group">
			<form:label path="breed">Breed</form:label>
			<form:errors path="breed"/>
			<form:input path="breed"/>
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<button>Submit</button>
	</form:form>
	<form action="/${dog.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input class="btn btn-danger" type="submit" value="Delete">
	</form>
</t:wrapper>