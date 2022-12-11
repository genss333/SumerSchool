<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<style><%@include file="/css/checkout.css"%></style>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<div class="container-xxl">
		<h2 style="text-align: center; padding-top: 3rem">Checkout Form</h2>
			<div
				class="col mb-0 container-xxl bg-white o-hidden border-0 shadow-lg my-5 px-4 px-lg-5 mt-5" 
				style="width: 50rem;">
				<br>
				<form class="card-body"
					action="execute_payment" method="post">
						<input type="hidden" name="paymentId" value="${param.paymentId}" />
						<input type="hidden" name="PayerID" value="${param.PayerID}" />
					<div class="border">
						<h5>Description List</h5>
						<c:forEach items="${item}" var="i">
							<input type="hidden" name="id" value="${i.getId()}" />
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Product/Service:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${i.getTitle()}
								</div>
							</div>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Product Quantity:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${qty}
								</div>
								<div class="p-2 bd-highlight">Pice</div>
							</div>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Total Price:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${i.getPrice()}
								</div>
								<div class="p-2 bd-highlight">Bath</div>
							</div>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Shipping Price:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">Free</div>
								<div class="p-2 bd-highlight"></div>
							</div>
							<hr>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Total Price: +
									Shipping Price:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${i.getPrice()*qty}
								</div>
								<div class="p-2 bd-highlight">Bath</div>
							</div>
							<hr>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Customer Name:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${payer.firstName} ${payer.lastName}
								</div>
							</div>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Email:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									${payer.email}
								</div>
							</div>
							<div class="d-flex bd-highlight mb-3">
								<div class="me-auto p-2 bd-highlightt">Shipping Address:</div>
								<div class="p-2 bd-highlight" style="padding-right: 1.5rem;">
									 ${shippingAddress.line1}, ${shippingAddress.city}, ${shippingAddress.state}, 
									 ${shippingAddress.countryCode}, ${shippingAddress.postalCode}
								</div>
							</div>
						</c:forEach>
					</div>
					<br>
					<button type="submit" value="Checkout" class="btn btn-primary form-control">Checkout</button>
				</form>
				<br>
				<br>
			</div>
		</div>
		<br><br><br>
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
</body>
</html>