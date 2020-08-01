<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page 404</title>
	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Josefin+Sans:400,700" rel="stylesheet"> 
	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>${statusCode}</h1>
			</div>
			<p>${exception}</p>
			<a href="${pageContext.request.contextPath}/">Go Home</a>
		</div>
	</div>
</body>
</html>