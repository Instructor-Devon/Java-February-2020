<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<div class="dog-details">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">${ dog.name }</h4>
				<p class="card-subtitle"><strong>Breed: </strong>${ dog.breed }</p>
				<p class="card-subtitle"><strong>Owner: </strong><a href="/${ dog.owner.id }">${ dog.owner.firstName }</a></p>
				<blockquote>"${ dog.description }"</blockquote>
				<h3>Liked by:</h3>
				<ul>
				<c:forEach items="${ dog.likers }" var="user">
					<li>${ user.firstName } ${ user.lastName }</li>
				</c:forEach>
				</ul>
				<c:if test="${ dog.toys.size() > 0 }">
				<section>
					<h2>Toys:</h2>
					<ol>
					<c:forEach items="${ dog.toys }" var="toy">
						<li>${ toy.name } (${ toy.price })</li>			
					</c:forEach>
					</ol>
				</section>
				</c:if>
		 	</div>
		 	<div class="card-body">
		 		<c:choose>
				<c:when test="${ dog.tag != null }">
					<h6>${ dog.tag.city }, ${ dog.tag.state }</h6>
					<a href="/dogs/state/${ dog.tag.state }">Find other dogs from ${ dog.tag.state }!</a>
				</c:when>
		 		<c:otherwise>
		 			<h3>Register this Dog!</h3>
					<form:form action="/dogs/tag" method="post" modelAttribute="tag">
						<form:hidden path="dog" value="${ dog.id }" />
						<div class="form-group">
							<form:label path="city">City</form:label>
							<form:errors path="city"/>
							<form:input path="city"/>
						</div>
						<div class="form-group">
							<form:label path="state">State</form:label>
							<form:errors path="state"/>
							<form:select path="state">
							<c:forEach items="${ states }" var="state">
								<option value="${ state.stateCode }">${ state.name }</option>
							</c:forEach>
							</form:select>
						</div>
						<button>Submit</button>
					</form:form>
		 		</c:otherwise>
		 		</c:choose>
		 	</div>
		</div>
		
	</div>
	<c:if test="${ dog.owner.id == userId }">
	<hr />
	<h3>Edit This Dog</h3>
	<form:form action="/dogs/${ dog.id }" method="post" modelAttribute="dog">
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
	<form action="/dogs/${dog.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input class="btn btn-danger" type="submit" value="Delete">
	</form>
	</c:if>
</t:wrapper>