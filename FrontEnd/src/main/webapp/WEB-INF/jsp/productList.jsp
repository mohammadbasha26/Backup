<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>


</head>
<body >
            <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
<br>
<br>
<c:if test="${param.update!=null}">
<h4 style="color:blue">Successfully Updated</h4>
</c:if>
<div class="container">
  <h2>Product  List</h2>
  <p>The Page of the Product list</p>            
<table class="table table-hover" id="product" class="display" border="1" width="80%" align="center">
                        <tr>
                            <th>ProductID</th>
                            <th>ProductName</th>
                            <th>ProductPrice</th>
                            <th>ProductDesc</th> 
                             <th>ProductInStock</th> 
                        </tr>
                        <c:if test="${empty productList}">
                            <tr>
                                <td colspan="7" align="center">No Record Exists</td>
                            </tr>
                        </c:if>
                        <c:forEach var="c" varStatus="st" items="${productList}">
                            <tr>
                                <td><c:out value="${st.count}"></c:out></td>
                                <td><c:out value="${c.productName}"></c:out></td>
                                <td><c:out value="${c.productPrice}"></c:out></td>
                                <td><c:out value="${c.productDesc}"></c:out></td>
                                <td><c:out value="${c.productInStock}"></c:out></td>
                                
                                
                            <td>
                         
                            <a class="btn btn-info" role="button" href="<c:url value="deleteProduct/${c.productID}" />">Delete</a>
			<a class="btn btn-info" role="button" href="<c:url value="updateProduct/${c.productID}"/>">Update</a>
                                </td> 
                            </tr>
                        </c:forEach>
                    </table>
                    
    <br>
    <br>      
    </div>
              
                                <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
                    
</body>

</html>