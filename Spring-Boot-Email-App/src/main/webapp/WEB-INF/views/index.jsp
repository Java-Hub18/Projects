<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Email App | Home</title>
<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">
</head>
<body><br> <br> <br>
	<center>
		<h3>Spring Boot Email Sending Application</h3>
	</center>
	<!-- Sign up form -->
	<section class="signup">
		<div class="container">
			<br>
			<div class="signup-image">

				<div style="display: flex; justify-content: space-between;">
					<a href="${pageContext.request.contextPath}/email-app/text-email" class="signup-image-link">Send Normal Text Email</a> 
					<a href="${pageContext.request.contextPath}/email-app/attachment-email" class="signup-image-link">Send Email With Attachment</a>
				</div>
			</div>
			<br> <br> <br>
		</div>
	</section>
</body>
</html>