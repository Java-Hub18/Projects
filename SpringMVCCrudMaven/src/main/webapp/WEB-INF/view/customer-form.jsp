<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Customer</title>

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
		<h3>Save Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<!-- need to associate with customer id -->
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
						<td><form:errors path="firstName" cssClass="error"></form:errors></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
						<td><form:errors path="lastName" cssClass="error"></form:errors></td>
					</tr>

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
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a> &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/home">Back
				to Home</a>
		</p>

	</div>

</body>

</html>










