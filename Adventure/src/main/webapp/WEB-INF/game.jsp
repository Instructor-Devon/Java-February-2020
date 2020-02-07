<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adventure Game!</title>
</head>
<body>
	<h1>${ level.title }</h1>
	<p>${ level.description }</p>
	<h3>You decide to...</h3>
	<c:forEach items="${ level.options }" var="option">
		<a href="/game/${ option.path }">${ option.description }</a>
	</c:forEach>
</body>
</html>