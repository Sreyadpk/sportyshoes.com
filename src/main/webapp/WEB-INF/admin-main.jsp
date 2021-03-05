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
					<li class="active"><a href="admin-main.jsp">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/home"><span class="glyphicon glyphicon-user"></span>
							Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">

		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">
			<h2>Welcome , Admin</h2>
			<div>
				<a href="/Admin/AddNewProduct" class="text-primary">Add new product</a>
			</div>
			<div>
				<a href="/Admin/ListProduct" class="text-primary">List of products</a>
			</div>
			<div>
				<a href="/Admin/Signedusers" class="text-primary">List of users signed up</a>
			</div>
			<div>
				<a href="/Admin/purchaseReport" class="text-primary">Purchase Report</a>
			</div>
		</div>
	</div>
</body>
</html>