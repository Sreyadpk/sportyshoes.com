<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
  <title>Welcome to Sports store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<body>
  <div class="container text-center">
    <h1>Welcome to Sports Store</h1>  
  </div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/home">Home</a></li>
        <li><a href="/products/all">Products</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/products/cart"><span class="glyphicon glyphicon-shopping-cart "></span>Cart</a></li>
        <li><a href="/logout"><span class="glyphicon glyphicon-user"></span>User Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">    
  <div class="row">
  <c:forEach items="${product}" var="product"> 
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> ${product.productname} </div>
        <div class="panel-body">
        <p>Brand : ${product.productbrand} </p>
        <p>Price : ${product.productprice}  </p>
		<p>Seller :  ${product.productseller} </p>  
        </div>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
        onClick="location.href='/products/${product.productid} ' ">Browse</button></div>
      </div>
    </div>
    </c:forEach>
  </div>
</div><br>

</body>
</html>