<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Login Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
<style>
.error {
	color: red;
}
</style>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Login Customer</h3>

		<form:form action="loginCustomer" modelAttribute="customer" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:password path="password" /></td>
						<td><form:errors path="password" cssClass="error"></form:errors></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/home">Back
				to Home</a>
		</p>

	</div>

</body>

</html>

