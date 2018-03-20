
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@include file="header.jsp"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


 	<link href="<c:url value="/resources/css/bootstrap.min.css"  />" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
</head>
<body>

<div class="container">
            <form modelAttribute="uproduct" action="${pageContext.request.contextPath}/admin/saveUProduct" class="form-horizontal" enctype="multipart/form-data" role="form" method="post" >
                <h2>Product Details</h2>
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Product Name</label>
                    <div class="col-sm-9">
                        <input name="productName" value="${uproduct.productName}" placeholder="Product Name" class="form-control" />
                        <input type="hidden" name="productID" value="${uproduct.productID}"/>
                        <span class="help-block"> </span>
                    </div>
                
                </div>
                <div class="form-group">
                    <label for="ProductPrice" class="col-sm-3 control-label">Product Price</label>
                    <div class="col-sm-3">
                        <input name="productPrice"  value="${uproduct.productPrice}" id="ProductPrice" placeholder="ProductPrice" class="form-control"/>
                    </div>
                </div>
                
                
                
                
                
                
                
                
                  <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Product In Stock</label>
                    <div class="col-sm-3">
                        <input name="productInStock"  value="${uproduct.productInStock}"  placeholder="Product In Stock" class="form-control"/>
                    </div>
                </div>
                
                
                
                 <div class="form-group">
                                   <label for="clist" class="col-sm-3 control-label">Category List</label>
               
             
				<div class="col-sm-3">
				<select name="category"  class="form-control">
					  <option value="NONE" >-------- Select -------</option>
					  						<c:forEach items="${clist}" var="c">
					  
					  <option  value="${c.categoryID}" >${c.categoryName}</option>
					
					  </c:forEach>
				       </select>
                                </div>
			
                </div>
                
                
                
                              <div class="form-group">
                                   <label for="ProductPrice" class="col-sm-3 control-label">Supplier List</label>
               
             
				<div class="col-sm-3">
				<select name="supplier"  class="form-control">
					  <option value="NONE" >---------select------------</option>
					  <c:forEach items="${slist}" var="s">
					  <option  value="${s.supplierID}" >${s.supplierName}</option>
					  
					  </c:forEach>
				       </select>
                                </div>
			
                </div>
               
              
          
                    
               
              <div class="form-group">
                <label for="productDesc"  placeholder="Product Description"  class="col-sm-3 control-label">Product Description</label>
                 <div class="col-sm-9">
                                  
<!--               <textarea name="productDesc" class="form-control"/>
 -->               <textarea class="form-control"  name="productDesc" rows="5" id="description"  >${uproduct.productDesc}</textarea>
              </div>
              </div>
              
              
              
              
              
                <div class="form-group">
                    <label for="firstName" class="col-sm-3 control-label">Image</label>
                    <div class="col-sm-3">
              <input class="form-control" type="file" name="file" accept="image/*"/>                    </div>
                </div>
              
              
              
              
              
                <div class="form-group">
                    <div class="col-sm-3 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block">Update</button>
                    </div>
                </div>
            <form> <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>