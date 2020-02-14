<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper>
	<h2>TEMP LOG IN!</h2>
	<form action="/temp/login" method="POST">
		<div class="form-group">
			<label for="user">Choose a User to log in as...</label>
			<select name="userid" id="user">
			<c:forEach items="${ users }" var="user">
				<option value="${ user.id }">${ user.firstName } ${ user.lastName }</option>
			</c:forEach>		
			</select>
		</div>
		<button>Log in</button>
	</form>
</t:wrapper>