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
<title>Employee | All Employees</title>
<!-- Main css -->
<!-- <link rel="stylesheet" href="/css/style.css"> -->
<link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet" href="/css/test.css"> 
</head>
<body style="background-color:#F0F3F4;">	
<br>
	<center>
		<h3>Spring Boot CRUD Example</h3>
	</center>
	<!-- Sign up form -->
	<section class="signup">
				<!-- put new button: Add Customer -->
		
				<br>
				<!--  add a search box -->
				<form:form action="search"  method="POST">
                 <input type="text" placeholder="Employee Id"	required="required" name="emp_id" />
					<input type="submit" name="search" id="search" class="form-submit" value="Search"/>
				</form:form>
				<!--  add our html table here -->
				<c:set var="count" value="0" scope="page" />
<br>
				<table border="1" style="border: 1px solid black;">
					<tr>
						<th>Sr.No</th>
						<th>Fname</th>
						<th>Lname</th>
						<th>Emp Id</th>
						<th>Email</th>
						<th>Gender</th>
						<th>DOB</th>
						<th>Department</th>
						<th>Designation</th>
					</tr>

<!-- loop over and print our employees -->
				<c:forEach var="theEmployee" items="${result}">
				<c:set var="count" value="${count + 1}" scope="page"/>
					<tr>
						<td>${count}</td>
						<td> ${theEmployee.firstName} </td>
						<td> ${theEmployee.lastName} </td>
						<td> ${theEmployee.empId} </td>
						<td> ${theEmployee.email} </td>
						<td> ${theEmployee.dob} </td>
						<td> ${theEmployee.gender} </td>
						<td> ${theEmployee.department} </td>
						<td> ${theEmployee.designation} </td>
						
					</tr>
				
				</c:forEach>
</table>

				<br><br>
				<div style="display: flex; justify-content: space-between;">
					<a href="${pageContext.request.contextPath}/employee/sign-in" class="signup-image-link">I am already member</a>
					<a href="${pageContext.request.contextPath}/employee/sign-up" class="signup-image-link">Create an account</a>
					<a href="${pageContext.request.contextPath}/employee/home" class="signup-image-link">Go Home</a>
				</div>
			
			<br> <br> <br>
	
	</section>
</body>
</html>