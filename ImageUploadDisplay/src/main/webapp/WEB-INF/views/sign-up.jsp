<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee | Sign up</title>
<!-- Font Icon -->
<link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet" href="/css/style.css">
<!-- Main js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
	<center><h3>Spring Boot Image Upload & Download Example</h3></center>
	<!-- Sign up form -->
	<section class="signup">
		<div class="container">
			<div class="signup-content">
				<div class="signup-form">
					<h3 class="form-title">Employee Sign-Up Form</h3>
					<form class="register-form" name="register-form" id="register-form" >
						<div class="form-group">
							<label for="fname"><i class="zmdi zmdi-account material-icons-name"></i></label>
							<input name="firstName" id="name" placeholder="Name" />
							<div class="help-block" id="error_name"></div>
						</div>
						<div class="form-group">
							<label for="designation"><i class="zmdi zmdi-account material-icons-name"></i></label>
							<input name="designation" id="designation" placeholder="Designation" />
							<div class="help-block" id="error_designation"></div>
						</div>
						<div class="form-group">
							<label for="attachment"><i class="zmdi zmdi-file"></i></label>
							<input type="file" name="file" accept="*" id="file" />
							<div class="help-block" id="error_file"></div>
						</div>
						<div class="form-group form-button">
							<input type="button" id="signup" class="form-submit" value="Submit" />
						</div>
					</form><br>
					<center><div id="success" style="color: green;font-weight: bold;font-size: 15px;"></div></center>
					<center><div id="error" style="color: red;font-weight: bold;font-size: 15px;"></div></center>
  <center>
  <img src="/images/loader.gif" alt="loader" style="width: 130px;height: 100px;" id="loader">
  </center>
				</div>
				<div class="signup-image">
					<figure>
						<img src="/images/signup-image.jpg" alt="sing up image">
					</figure>
					<div style="display: flex; justify-content: space-between;">
						<a href="${pageContext.request.contextPath}/image-upload/employees"
							class="signup-image-link">View Employees</a> <a
							href="${pageContext.request.contextPath}/image-upload/home"
							class="signup-image-link">Go Home</a>
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