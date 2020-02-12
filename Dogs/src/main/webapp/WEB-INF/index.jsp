<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
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
</t:wrapper>