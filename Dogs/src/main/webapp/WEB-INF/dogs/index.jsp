<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>All Of Our Dogs!</h2>
	<h3>Greetings, ${ user.firstName }</h3>
	<a href="/dogs/new">Add a Dog</a>
	<hr />
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Action</th>
				<th>Name</th>
				<th>Breed</th>
				<th>Description</th>
				<th>Likes</th>
				<th>Value of Toys</th>
				<th>Registered?</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ dogs }" var="dog">
			<tr>
				<td>
					<c:choose>
					<c:when test="${ !dog.likers.contains(user) }">
						<a href="/dogs/like/${ dog.id }">Like</a>
					</c:when>
					<c:otherwise>
						<a href="/dogs/unlike/${ dog.id }">Un-Like</a>
					</c:otherwise>
					</c:choose>
				</td>
				<td><a href="/dogs/${ dog.id }">${ dog.name }</a></td>
				<td>${ dog.breed }</td>
				<td>${ dog.description }</td>
				<td>${ dog.likers.size() }</td>
				<td>${ dog.getToysTotalValue() }</td>
				<td>
					<c:choose>
						<c:when test="${ dog.tag != null }">
							${ dog.tag.getDetails() }
						</c:when>
						<c:otherwise><span style="color: red">Not Registered</span></c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</t:wrapper>