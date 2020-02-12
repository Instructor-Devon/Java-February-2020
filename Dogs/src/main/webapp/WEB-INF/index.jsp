<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>All Of Our Dogs!</h2>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Id <a href="#">^</a></th>
				<th>Name <a href="/sort/name/0">^</a></th>
				<th>Breed <a href="#">^</a></th>
				<th>Description <a href="#">^</a></th>
				<th>Registered? <a href="#">^</a></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ dogs }" var="dog">
			<tr>
				<td>${ dog.id }</td>
				<td><a href="/${ dog.id }">${ dog.name }</a></td>
				<td>${ dog.breed }</td>
				<td>${ dog.description }</td>
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