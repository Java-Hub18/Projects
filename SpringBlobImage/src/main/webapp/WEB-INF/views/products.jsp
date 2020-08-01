<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Java Hub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css">
</head>
<body>
<br>
<h1 class="text-center">Spring Boot Image Upload &amp; Display With Blob Using Database
<a href="${pageContext.request.contextPath}/home" class="btn btn-danger text-right">Go Home</a>
</h1>
<br><br>
<table id="example" class="table table-striped table-bordered text-center">
        <thead>
            <tr>
                <th>SR. No.</th>
                <th>Name</th>
                <th>Image</th>
                <th>Description</th>
                <th>Price</th>
                <th>Created date</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:set var="count" value="0" scope="page"></c:set>
        <c:forEach var="product" items="${products}">
        <c:set var="count" value="${count + 1}" scope="page"></c:set>
            <tr>
                <td>${count}</td>
                <td>${product.name}</td>
                <td><img src="${pageContext.request.contextPath}/product/display/${product.id}" /></td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${product.createDate}" /></td>
                <td><a href="${pageContext.request.contextPath}/product/productdetails?id=${product.id}" class="btn btn-info text-right" target="_blank">View</a></td>
            </tr>
         </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th>SR. No.</th>
                <th>Name</th>
                <th>Image</th>
                <th>Description</th>
                <th>Price</th>
                <th>Created date</th>
                <th>Action</th>
            </tr>
        </tfoot>
    </table>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	    $('#example').DataTable();
	} );
	</script>
</body>
</html>