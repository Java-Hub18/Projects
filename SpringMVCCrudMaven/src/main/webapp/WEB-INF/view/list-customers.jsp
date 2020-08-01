<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='customer-form'; return false;"
				   class="add-button"
			/><br>
		 <!--  add a search box -->
            <form:form action="search" method="POST">
                Search customer: <input type="text" placeholder="Email" required="required" name="email" /> 
                <input type="submit" value="Search" class="add-button" />
            </form:form>
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				<!-- Construct an update link -->
				<c:url var="update" value="updateCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<!-- Construct an delete link -->
				<c:url var="delete" value="deleteCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> ${tempCustomer.password} </td>
						<td> <a href="${update}">Update</a> |
						 <a href="${delete}" onclick="return confirm('Are you sure ou want to delete this customer?');">Delete</a> </td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
<p>
			<a href="${pageContext.request.contextPath}/home">Back
				to Home</a>
		</p>

</body>

</html>









