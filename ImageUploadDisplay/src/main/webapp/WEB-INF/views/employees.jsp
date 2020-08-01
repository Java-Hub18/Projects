<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<!-- Sign up form -->
	<section class="signup">
		
				<br>
				<!--  add our html table here -->
				<c:set var="count" value="0" scope="page" /><br>
				<table border="1" style="border: 1px solid black;">
					<tr>
						<th>Sr.No</th>
						<th>Name</th>
						<th>Designation</th>
						<th>File Name</th>
						<th>File Size</th>
						<th>File Type</th>
						<th>Image</th>
						<th>Created Date</th>
						<th>Action</th>
					</tr>
			<c:choose>
				<c:when test="${not empty employeeList}">
					<!-- loop over and print our employees -->
				<c:forEach var="theEmployee" items="${employeeList}">
				<c:set var="count" value="${count + 1}" scope="page"/>
					<tr>
						<td>${count}</td>
						<td> ${theEmployee.name} </td>
						<td> ${theEmployee.designation} </td>
						<td> ${theEmployee.fileName} </td>
						<td> ${theEmployee.fileSize} </td>
						<td> ${theEmployee.fileType} </td>
						<td><img src="/uploads/${theEmployee.fileName}" width="270" height="250" /> </td>
						<td> ${theEmployee.createdDate} </td>
		<td> 
		<a href="${pageContext.request.contextPath}/image-upload/removeFile/${theEmployee.id}/${theEmployee.fileName}" onclick="return confirm('Are you sure you want to delete ${theEmployee.name}?');">Delete</a>
		</td>
					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<center><h1>No Employee Found.</h1></center>
				</c:otherwise>
			</c:choose>
				
</table>

				<br><br>
				<div style="display: flex; justify-content: space-between;">
						<a href="${pageContext.request.contextPath}/image-upload/employees"
							class="signup-image-link">View Employees</a>
							<a href="${pageContext.request.contextPath}/image-upload/sign-up" class="signup-image-link">Sign Up</a> 
							 <a
							href="${pageContext.request.contextPath}/image-upload/home"
							class="signup-image-link">Go Home</a>
					</div>
			
			<br> <br> <br>
	
	</section>
</body>
</html>