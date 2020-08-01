<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Hub</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<br>
	<div class="banner-bootom-w3-agileits py-5">
		<div class="container py-xl-4 py-lg-2">
			<!-- tittle heading -->
			<h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
				<span>P</span>roduct
				<span>D</span>etails</h3><br>
			<!-- //tittle heading -->
			<div class="row">
				<div class="col-lg-5 col-md-8 single-right-left ">
					<div class="grid images_3_of_2">
						<div class="flexslider">
						<div class="thumb-image">
							<img src="${pageContext.request.contextPath}/product/display/${id}" 
							 class="img img-responsive img-fluid" alt=""> 
						</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>

				<div class="col-lg-7 single-right-left simpleCart_shelfItem">
					<h3 class="mb-3">Name : ${name}</h3>
					<p class="mb-3">
						Price : <span class="item_price">&#x20b9;${price}</span>
					</p>
					<div class="product-single-w3l">
						<p class="my-sm-4 my-3">
							Description : ${description}
						</p>
					</div><br>
					<a href="${pageContext.request.contextPath}/product/show">Go Back</a>
					&emsp;<a href="${pageContext.request.contextPath}/">Go Home</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>