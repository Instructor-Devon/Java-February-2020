<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>Dogs From ${ state }</h2>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Breed</th>
				<th>Description</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ dogs }" var="dog">
			<tr>
				<td><a href="/${ dog.id }">${ dog.name }</a></td>
				<td>${ dog.breed }</td>
				<td>${ dog.description }</td>
				<td>${ dog.tag.state }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</t:wrapper>