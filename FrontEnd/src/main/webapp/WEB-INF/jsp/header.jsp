 <!DOCTYPE html> 
<html lang="en">
 <head>
  <title>Toy's Store</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body> 

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">

     <li class="active"><a class="navbar-brand" href="${pageContext.request.contextPath}/">Toy's Store</a></li>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a href="home"><span class="glyphicon glyphicon-home">&nbsp</span>Home</a></li>
      
      
   <!--  (((comment line)))  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">List <span class="caret"></span></a>
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
      
    <li><a href="#">Page 2</a></li>          (((comment line)))-->
    
    
    
      <li class="active"><a href="product"><span class="glyphicon glyphicon-pencil">&nbsp</span>Product</a></li>
        <li class="active"><a href="category"><span class="glyphicon glyphicon-pencil">&nbsp</span>Category</a></li>
        <li class="active"><a href="supplier"><span class="glyphicon glyphicon-import">&nbsp</span>Supplier</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a href="about"><span class="glyphicon glyphicon-about"></span> About Us</a></li>
              <li><a href="logout"><span class="glyphicon glyphicon-about"></span> Logout</a></li>
       
    </ul>
  </div>
  
  
</nav>
  
<div class="container">
  <h3>Welcome to the Kids World</h3>
  <p>Enjoy with your Dreams</p>
</div>

<!-- </body>
</html> -->
