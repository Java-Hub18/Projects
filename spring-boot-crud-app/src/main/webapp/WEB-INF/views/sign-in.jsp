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
    <title>Employee | Sign in</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<center><h3>Spring Boot CRUD Example</h3></center>
 <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="/images/signin-image.jpg" alt="sing up image"></figure>
		                <div style="display: flex; justify-content: space-between;">
							<a href="${pageContext.request.contextPath}/employee/sign-up" class="signup-image-link">Create an account</a>
							<a href="${pageContext.request.contextPath}/employee/home" class="signup-image-link">Go Home</a>
						</div>
                        <spring:url value="/employee/validateEmployee" var="sign-in-URL" />
                    </div>

                    <div class="signin-form">
                        <h3 class="form-title">Employee Sign-In Form</h3>
                        <form:form modelAttribute="employee-sign-in" action="/employee/validateEmployee" method="POST" 
                        cssClass="register-form" id="login-form">
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <form:input type="email" path="email" name="email" id="email" placeholder="Email" required="required"/>
                            	<form:errors path="email" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="password"><i class="zmdi zmdi-lock"></i></label>
                               <form:password path="password" name="pass" id="pass" placeholder="Password" required="required"/>
                               <form:errors path="password" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form:form> 
                    </div>
                </div>
            </div>
        </section>


    <!-- JS -->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/js/main.js"></script>
</body>
</html>