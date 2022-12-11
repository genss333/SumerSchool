<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="Error.jsp" %> 
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>
<title>GensShop</title>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<div
			class="container-xxl bg-white o-hidden border-0 shadow-lg my-5 px-4 px-lg-5 mt-5">
			<h1 class="header" style="text-align: center;"><%= request.getParameter("header") %></h1>
			<div
				class="row gx-4 gx-lg-4 row-cols-2 row-cols-md-3 row-cols-xl-4 row-cols-xxl-4
                justify-content-center" style="margin-bottom: 4rem;">
                <c:forEach items="${products}" var="p">
                	<a href="<%=request.getContextPath()%>/ProductDetailServlet?pid=${p.getId()}&&col=${p.getCollection()}&&brand=${p.getBrand()}"
                	 style="text-decoration: none;">
	                	 <div class="col mb-5">
		                    <div class="card productsale h-100" style="width:100%;">
		                        <c:if test = "${p.getStatus()=='onsale'}">
						         	 <div class="bg-danger text-white" style="width:50%;text-align:center;">SALE</div>
						      	</c:if>
						      	<c:if test = "${p.getStatus()==''}">
						         	 <br>
						      	</c:if>
		                            <img src="${p.getImage()}" class="card-img-top"/>
		                        <div class="card-body">
		                            <p class="fw-bolder product-title" style="color:black;">${p.getTitle()}</p>
		                            <div class="d-flex" style="color:black;">
		                            <c:if test = "${p.getStatus()=='onsale'}">
		                            	<div style="text-decoration:line-through;color:red;">
		                                    <fmt:formatNumber value = "${p.getPrice()}" type = "number"/> Bath
		                                </div>
		                                &nbsp;&nbsp;&nbsp;
		                                <div >
		                                     <fmt:formatNumber value = "${p.getSale()}" type = "number"/> Bath
		                                </div>
						      		</c:if>
		                            <c:if test = "${p.getStatus()==''}">
		                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                <div >
		                                     <fmt:formatNumber value = "${p.getPrice()}" type = "number"/> Bath
		                                </div>
						      		</c:if>
		                            </div>
		                        </div>
		                    </div>
	                	</div>
                	</a>
                </c:forEach>
			</div>
			<!-- Pagination -->
			<%@ include file="./Component/Pagination.jsp"%>
			<br>
		</div>
	<!-- Help Center -->
	<%@ include file="./Component/HelpCenter.jsp"%>
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
</body>
</html>