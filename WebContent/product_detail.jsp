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
<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>
<title>GensShop</title>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<!-- Product section-->
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<c:forEach items="${products}" var="p">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0" src="${p.getImage()}" />
					</div>
					<div class="col-md-6">
						<div class="small mb-1">SKU: BST-498</div>
						<h1 class="display-5 fw-bolder">${p.getTitle()}</h1>
						<c:if test="${p.getStatus()=='onsale'}">
							<div class="fs-5 mb-5">
								<span class="text-decoration-line-through"><fmt:formatNumber value="${p.getPrice()}" type="number" /> Bath</span>
								 <span><fmt:formatNumber value="${p.getSale()}" type="number" /> Bath</span>
							</div>
						</c:if>
						<c:if test="${p.getStatus()==''}">
							<div class="fs-5 mb-5">
								<span class="text-decoration-line-through"></span> <span><fmt:formatNumber
										value="${p.getPrice()}" type="number" /> Bath</span>
							</div>
						</c:if>
						<p class="lead">${p.getDes()}</p>
						<p class="txt-boid">In Stock: ${p.getStk()}</p>
						<form class="d-flex" action="AddCartServlet?id=${p.getId()}&&col=${p.getCollection()}&&brand=${p.getBrand()}" method="post" >
							<input class="form-control text-center me-3"
								type="number" min="1" max="${p.getStk()}" value="1" name="qty" style="max-width: 4rem;" />
							<button type="submit" id="addToCart" class="btn btn-outline-dark flex-shrink-0" type="button">
								<i class="bi-cart-fill me-1"></i> Add to cart
							</button>
						</form>
					</div>

				</c:forEach>
			</div>
		</div>
	</section>
	<!-- Relate Items -->
	<%@ include file="./Component/RelateItems.jsp"%>
	<!-- Help Center -->
	<%@ include file="./Component/HelpCenter.jsp"%>
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
</body>
</html>