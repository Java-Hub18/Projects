<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
<center><h3>Spring Boot CRUD Example</h3></center>
     <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h3 class="form-title">Employee Sign-Up Form</h3>
                        <form:form modelAttribute="employee-sign-up" method="POST" action="/employee/saveEmployee" cssClass="register-form"
                         id="register-form">
                             <form:hidden path="id"/>
                            <div class="form-group">
                                <label for="fname"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input path="firstName" name="firstName" id="firstName" placeholder="First Name" required="required"/>
                            	<form:errors path="firstName" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="lname"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input path="lastName" name="lastName" id="lastName" placeholder="Last Name" required="required"/>
                            	<form:errors path="lastName" cssStyle="color:red;" cssClass="error"/>
                            </div>
                             <c:choose> 
 								  <c:when test="${not empty testData}"> 
 								    <div class="form-group">
 		                                <label for="email"><i class="zmdi zmdi-email"></i></label> 
 		                                <form:input type="email" path="email" readonly="true" name="email" id="email" placeholder="Email"
 		                                 required="required"/> 
 		                            	<form:errors path="email" cssStyle="color:red;" cssClass="error"/> 
                             	   </div> 
 								  </c:when> 
 								  <c:otherwise> 
 								   	<div class="form-group"> 
 		                                <label for="email"><i class="zmdi zmdi-email"></i></label> 
 		                                <form:input type="email" path="email" name="email" id="email" placeholder="Email" required="required"/> 
 		                            	<form:errors path="email" cssStyle="color:red;" cssClass="error"/> 
                             		</div> 
 								  </c:otherwise> 
								</c:choose> 
	                            <c:choose>  
								  <c:when test="${not empty testData}">
								    <div class="form-group">
		                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
		                                <form:password path="password" name="pass" value="${passwords}" id="pass" placeholder="Password"/>
	                            		<form:errors path="password" cssStyle="color:red;" cssClass="error"/>
                           			</div>
								  </c:when>
								  <c:otherwise>
								   	<div class="form-group">
		                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
		                                <form:password path="password" name="pass" id="pass" placeholder="Password" required="required"/>
	                            		<form:errors path="password" cssStyle="color:red;" cssClass="error"/>
                           			</div>
								  </c:otherwise>
							</c:choose>
                            <div style="display: flex; justify-content: space-between;" class="form-group"> 
                                Male: <form:radiobutton path="gender" value="Male"/>
								Female: <form:radiobutton path="gender" value="Female"/>
								<form:errors path="gender" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="dob"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="date" path="dob" id="dob" name="dob" required="required"/>
                                <form:errors path="dob" cssStyle="color:red;" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="department"><i class="zmdi zmdi-account material-icons-name"></i></label>&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:select path="department" name="department" id="department" 
                                cssStyle="border: 1px solid #ccc;background: transparent;border: none;font-size: 14px;height: 29px;padding: 5px;
                                width: 268px;" cssClass="" required="required">
                                <form:option value="">---Select Department--</form:option>
	                                <form:option value="IT">IT</form:option>
	                                <form:option value="Bank">Bank</form:option>
	                                <form:option value="Yoga">Yoga</form:option>
	                                <form:option value="Business">Business</form:option>
	                                <form:option value="Art & Culture">Art & Culture</form:option>
	                                <form:option value="Forest">Forest</form:option>
                                </form:select>                      
                                <form:errors path="department" cssStyle="color:red;" cssClass="error"/>  
                            </div>
                            <div class="form-group">
                                <label for="designation"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input path="designation" name="designation" id="designation" placeholder="Designation" required="required"/>
                            	<form:errors path="designation" cssStyle="color:red;" cssClass="error"/>  
                            </div>   
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term"  required="required"/>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  
                                <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                            <input type="hidden" name="testData" value="${testData}"/>
                        </form:form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="/images/signup-image.jpg" alt="sing up image"></figure>
                 <div style="display: flex; justify-content: space-between;">
					<a href="${pageContext.request.contextPath}/employee/sign-in" class="signup-image-link">I am already member</a> 
					<a href="${pageContext.request.contextPath}/employee/home" class="signup-image-link">Go Home</a>
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