<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<form:form action="/toys" method="post" modelAttribute="toy">
		<div class="form-group">
			<form:label path="dog">Gift this toy to:</form:label>
			<form:errors path="dog"/>
			<form:select path="dog">
			<c:forEach items="${ dogs }" var="dog">
				<option value="${ dog.id }">${ dog.name }</option>
			</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label>
			<form:errors path="price"/>
			<form:input type="decimal" path="price"/>
		</div>
		<div class="form-group">
			<form:label path="description">Description</form:label>
			<form:errors path="description"/>
			<form:input path="description"/>
		</div>
		<button>Submit</button>
	</form:form>
	
</t:wrapper>