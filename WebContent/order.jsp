<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous">
	
</script>
<title>GensShop</title>
<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>
</head>
<body>
<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<div class="container-xxl my-5 px-4 px-lg-5 mt-5">
        <h2 class="my-5 h2 text-center">Your Order</h2>
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Products</th>
                    <th scope="col" style="width: 10%;">Quantity</th>
                    <th scope="col" style="width: 10%;text-align:center;">Date</th>
                    <th scope="col" style="width: 15%;text-align:center;">Status</th>
                    <th scope="col" style="width: 10%;text-align:center;">Cancel</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach items="${order}" var="o">
	            	<tr>
	                    <td>
	                        <div class="row gx-1 gx-lg-1 row-cols-1 row-cols-md-2 row-cols-xl-3 row-cols-xxl-3">
	                            <div class="col gx-md-3">
	                                <div class="h-100" style="max-width: 10rem;">
	                                    <img src="${o.getImage()}" class="card-img-top" />
	                                </div>
	                            </div>
	                            <div class="col gx-md-3">
	                                <br>
	                                <p class="product-title" style="color:black;">${o.getTitle()}</p><br>
	                                <span style="color:black;">Price: <fmt:formatNumber value="${o.getPrice()}"/> Bath</span><br>
	                                <span style="color:black;">Total Price: <fmt:formatNumber value="${o.getPrice() * o.getQty()}"/> Bath</span>
	                            </div>
	                        </div>
	                    </td>
	                    <td>
	                        <p style="padding-top: 3rem;padding-left: 1rem;">
	                            ${o.getQty()}
	                        </p>
	                    </td>
	                    <td><p style="padding-top: 3rem;text-align:center;">${o.getDate()}</p></td>
	                    <td>
	                        <p class="text-success" style="padding-top: 3rem;text-align:center;">${o.getStatus()}</p>
	                    </td>
	                    <c:if test="${o.getStatus() == 'pay'}">
	                    	<td style="padding-top: 3.5rem;padding-left: 2rem;"><a href="RemoveOrderServlet?id=${o.getId()}&&pid=${o.getPid()}"><i class="bi bi-trash-fill"></i></a></td>
	                    </c:if>
	                </tr>
            	</c:forEach>
            </tbody>
        </table>
        <!-- Pagination -->
		<%@ include file="./Component/Pagination.jsp"%>
    </div>
    <!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
</body>
</html>