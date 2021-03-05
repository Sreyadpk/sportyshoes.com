<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome to Sports store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container text-center">
		<h1>Welcome to Sports Store</h1>
	</div>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/home"><span class="glyphicon glyphicon-user"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<h2>Purchase Report</h2>
	<div class="container">
		<div class="input-group">
			<div class="form-outline">
				<form action="/Admin/purchaseReport">
				<p>Filter By Date/Brand</p>
					<input type="text" name="keyword" placeholder="Search" /> <input
						type="submit" value="search" />
				</form>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Product Brand</th>
					<th>Product Price</th>
					<th>Ordered Date</th>
					<th>Ordered Quantity</th>
					<th>Ordered By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="orders">
					<c:set var="product" value="${orders.product}" />
					<c:set var="user" value="${orders.user}" />
					<tr>
						<td>${product.productname}</td>
						<td>${product.productbrand}</td>
						<td>${product.productprice}</td>
						<td>${orders.orderdate}</td>
						<td>${orders.quantity}</td>
						<td>${user.username}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/Admin/GoBack" class="text-primary">Go Back</a>
		</div>
	</div>
</body>
</html>