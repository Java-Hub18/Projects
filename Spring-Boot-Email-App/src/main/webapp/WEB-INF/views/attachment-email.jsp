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
<title>Attachment Email Form</title>

<!-- Font Icon -->
<link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<center>
		<h3>Spring Boot Email Sending Application</h3>
	</center>
	<!-- Text Email form -->
	<section class="signup">
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h3 class="form-title">Attachment Email Form</h3>
					<form:form modelAttribute="attachmentEmail" method="POST" action="/email-app/sendAttachmentEmail" cssClass="register-form"
						id="register-form" enctype="multipart/form-data">
						<div class="form-group">
							<label for="fname"><i class="zmdi zmdi-account material-icons-name"></i></label>
							<form:input path="name" name="name" id="name" placeholder="Name" required="required" />
							<form:errors path="name" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="phone"><i class="zmdi zmdi-phone"></i></label>
							<form:input path="phone" name="phone" id="phone"  placeholder="Phone" required="required" />
							<form:errors path="phone" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="email"><i class="zmdi zmdi-email"></i></label>
							<form:input type="email" path="email" name="email" id="email" placeholder="Email" required="required" />
							<form:errors path="email" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="subject"><i class="zmdi zmdi-account material-icons-name"></i></label>
							<form:input path="subject" name="subject" id="subject" placeholder="Subject" required="required" />
							<form:errors path="subject" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">	
							<form:textarea path="comment" name="comment" id="comment" placeholder="Comment" rows="5" cols="35" required="required" />
							<form:errors path="comment" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group">
							<label for="attachment"><i class="zmdi zmdi-file"></i></label>
							<form:input path="attachment" type="file" name="attachment"  id="attachment" required="required" />
							<form:errors path="attachment" cssStyle="color:red;" cssClass="error" />
						</div>
						<div class="form-group form-button">
							<input type="submit" id="signup" class="form-submit" value="Send" />
						</div>
					</form:form>
				</div>
				<div class="signup-image">
					<figure>
						<img src="/images/signup-image.jpg" alt="sing up image">
					</figure>
					<div style="display: flex; justify-content: space-between;">
					<a href="${pageContext.request.contextPath}/email-app/text-email" class="signup-image-link">Send Normal Text Email</a> 
					<a href="${pageContext.request.contextPath}/email-app/home" class="signup-image-link">Go Home</a> 
				</div>
				</div>
			</div>
		</div>
	</section>

	<!-- JS -->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/js/main.js"></script>
</body>
</html>