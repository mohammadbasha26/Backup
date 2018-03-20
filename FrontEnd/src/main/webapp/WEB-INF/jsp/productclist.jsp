
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
     
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet">

    <!-- Custom CSS -->
 	<link href="<c:url value="/resources/css/shop-homepage.css"  />" rel="stylesheet">
             <!-- jQuery -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>

    <!-- Bootstrap Core JavaScript -->
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
               

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products by Categories  </title>
</head>
<body>

 <body>
           <%@include file="header.jsp" %>

            
            
             <table class="table table-hover">
    <thead>
      <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Stock</th>
        <th>Image</th>
        
        
      </tr>
    </thead>
    <tbody>
        <c:if test="${empty custProducts}">
            <tr class="danger"><td colspan="5"><center><h3>No Products</h3></center></td> </tr></c:if>
        
                          <c:forEach items="${custProducts}" var="p">

      <tr class="success"> 
          
        <td>${p.productName}</td>
        <td>${p.productPrice}</td>
                <td>${p.productDesc}</td>
        <td>${p.productInStock}</td>
       <td><a href="${pageContext.request.contextPath}/productDescription/${p.productID}"><img  src="${pageContext.request.contextPath}/resources/images/<c:out value='${p.imgName}'></c:out>" height="50px" width="50px"/></a></td>

      
                 
     
      </tr>
       </c:forEach>
    </tbody>
  </table>
               <%@include file="footer.jsp" %>
    
    </body>
</html>