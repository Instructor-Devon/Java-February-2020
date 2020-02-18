<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>User Details for ${ user.firstName } ${ user.lastName }</h2>
	<hr />
	<h3>Dogs Owned:</h3>
	<ul>
	<c:forEach items="${ user.dogsOwned }" var="dog">
		<li><a href="/dogs/${ dog.id }">${ dog.name }</a></li>
	</c:forEach>
	</ul>
</t:wrapper>