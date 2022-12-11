<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>GensShop</title>
<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>

</head>
<body>
	<c:if test="${alert == true}">
		<script type="text/javascript">
			alert("SingIn Success");
		</script>
	</c:if>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	
	<!-- Carusel -->
	<%@ include file="./Component/Carousel.jsp"%>
	
	<!-- Best Seller -->
	<%@ include file="./Component/BestSeller.jsp"%>
	
	<!-- Best Price -->
	 <%@ include file="./Component/BestPrice.jsp"%> 
	
	<!-- On Sales -->
	<%@ include file="./Component/Onsale.jsp"%>
	
	<!-- Help Center -->
	<%@ include file="./Component/HelpCenter.jsp"%> 
	
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
	
</body>
</html>