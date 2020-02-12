<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<c:forEach items="${ errors }" var="err">
		<p>${ err }</p>
	</c:forEach>
	<form:form action="/" method="post" modelAttribute="dog">

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
			<p>TODO: Make this work with uploading</p>
			<form:label path="image">Image</form:label>
			<form:errors path="image"/>
			<form:input path="image"/>
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<button>Submit</button>
	</form:form>
	
</t:wrapper>