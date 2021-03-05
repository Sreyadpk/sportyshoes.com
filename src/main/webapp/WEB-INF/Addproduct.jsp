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

	<div style="padding-top: 30px" class="panel-body">

		<form:form modelAttribute="product" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="productname">Product Name:</label>
				<form:input path="productname" type="text" class="form-control"
					placeholder="productname" />
				<form:errors path="productname" />
			</div>

            <div class="form-group">
				<label for="productbrand">Product Brand:</label>
				<form:input path="productbrand" type="text" class="form-control"
					placeholder="productbrand" />
				<form:errors path="productbrand" />
			</div>
			
			<div class="form-group">
				<label for="productprice">Product Price:</label>
				<form:input path="productprice" type="number" class="form-control"
					placeholder="productprice" />
				<form:errors path="productprice" />
			</div>
			
			<div class="form-group">
				<label for="productseller">Product Seller:</label>
				<form:input path="productseller" type="text" class="form-control"
					placeholder="productseller" />
				<form:errors path="productseller" />
			</div>
			
			<div class="form-group">
				<label for="productcount">Product Count:</label>
				<form:input path="productcount" type="number" class="form-control"
					placeholder="productcount" />
				<form:errors path="productcount" />
			</div>


			<div style="margin-top: 10px" class="form-group" align='center'>
				<!-- Button -->

				<div class="col-sm-12 controls">
					<form:button type='success' class="btn btn-success">Add Product </form:button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>