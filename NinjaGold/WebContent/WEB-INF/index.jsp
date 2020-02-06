<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/main.css" />
</head>
<body>
	<h1>Ninja Gold</h1>
	<h2><input type="text" disabled value="${ gold }" /></h2>
	<c:forEach items="${ buildings }" var="building">
		<div class="building">
			<h4>${ building.name }</h4>
			<p>Get <c:if test="${building.canLose}">/ Lose</c:if> (${ building.min }-${ building.max }) gold from the ${ building.name }</p>
			<form action="/NinjaGold/Home" method="POST">
				<input type="hidden" name="building" value="${ building.name }"/>
				<button>Get Gold</button>
			</form>
		</div>
	</c:forEach>
	
</body>
</html>