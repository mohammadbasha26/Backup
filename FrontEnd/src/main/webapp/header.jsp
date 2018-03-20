<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Toy's Store</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			 <img src="./resources/images/Donald_Duck_transparent.png"alt=""style="width:200px;height:200px;" >

				<li class="active"><a class="navbar-brand"
					href="${pageContext.request.contextPath}/">Toy's Store</a></li>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/home"><span
						class="glyphicon glyphicon-home">&nbsp</span>Home</a></li>

				<!--       
     (((comment line)))  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">List <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="/">Home</a></li>
          <li><a href="login">Login</a></li>
         <li><a href="register">Register</a></li>
         <li><a href="product">Product</a></li>
         <li><a href="category">Category</a></li>
         <li><a href="about">About Us</a></li>
         <li><a href="supplier">Supplier</a></li>
        </ul>
      </li> 
      
    <li><a href="#">Page 2</a></li>          (((comment line)))
    
     -->

				<li class="active"><a
					href='<c:url value="/admin/product"></c:url>'><span
						class="glyphicon glyphicon-pencil">&nbsp</span>Product</a></li>
				<li class="active"><a
					href='<c:url value="/admin/category"></c:url>'><span
						class="glyphicon glyphicon-pencil">&nbsp</span>Category</a></li>
				<li class="active"><a
					href='<c:url value="/admin/supplier"></c:url>'><span
						class="glyphicon glyphicon-import">&nbsp</span>Supplier</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name!= null}">

					<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name== null}">

					<li><a href="register"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</c:if>
				<li><a href="about"><span class="glyphicon glyphicon-about"></span>
						About Us</a></li>
				<c:if test="${pageContext.request.userPrincipal.name!= null}">

					<li><a href="${pageContext.request.contextPath}/logout"><span
							class="glyphicon glyphicon-about"></span> Logout</a></li>
				</c:if>
			</ul>
		</div>


	</nav>

	<div class="container">
		<h3>Welcome to the Kids World</h3>
		<p>Enjoy with your Dreams</p>
	</div>

	<!-- </body>
</html> -->