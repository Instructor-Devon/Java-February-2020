<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Fondamento&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css" />
<script src="/js/main.js"></script>
<title>Dogs App!</title>
</head>
<body>
	<div class="container">
	<h1>Welcome to Dogs Dot Com!</h1>
	<nav>
		<a href="/dogs">Dogs</a>
		<a href="/toys">Toys</a>
		<a href="/logout">Logout</a>
	</nav>
	<hr />
	<jsp:doBody/>
	</div>
</body>
</html>