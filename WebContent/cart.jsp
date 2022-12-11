<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
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
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
		<div class="container-xxl my-5 px-4 px-lg-5 mt-5">
        <table class="table">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Products</th>
                    <th scope="col" style="width: 15%;">Quantity</th>
                    <th scope="col" style="width: 15%;">Checkout</th>
                    <th scope="col" style="width: 15%;">Delete</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${cart}" var="c">
            <form action="authorize_payment?id=${c.getId()}&&product=${c.getTitle()}&&subtotal=${c.getPrice()}
            &&qty=${c.getQuantity()}" method="post">
            	<tr>
                    <td>
                        <div class="row gx-1 gx-lg-1 row-cols-2 row-cols-md-2 row-cols-xl-3 row-cols-xxl-3">
                            <div class="col gx-md-3">
                                <div class="h-100" style="max-width: 10rem;">
                                    <a href="<%=request.getContextPath() %>/ProductDetailServlet?pid=${c.getId()}&&col=${c.getCollection()} &&brand=${c.getBrand()}">
                                    	<img src="${c.getImage()}" class="card-img-top" />
                                    </a>
                                </div>
                            </div>
                            <div class="col gx-md-3">
                                <br>
                                <p class="product-title" style="color:black;">${c.getTitle()}</p>
                                <span style="color:black;">Price: <fmt:formatNumber value="${c.getPrice()}" type="number" /> Bath</span><br>
                                <span style="color:black;">Total Price: <fmt:formatNumber value="${ c.getPrice() * c.getQuantity()}" type="number" /> Bath</span>
                            </div>
                        </div>
                    </td>
                    <td>
                    
                        <p style="padding-top: 3rem;padding-left: 1rem;">
	                        <a href="<%=request.getContextPath() %>/UpdateCartServlet?action=inc&&id=${c.getId()}"><i class="bi bi-plus"></i></a>
	                            ${c.getQuantity()}
	                         <a href="<%=request.getContextPath() %>/MinusCartServlet?action=dec&&id=${c.getId()}"><i class="bi bi-dash"></i></a>
                        </p>
                    </td>
                    <td style="padding-top: 3.5rem;padding-left: 1rem;">
                    	<button type="submit" value="Checkout" style="border:none;background:none;"><i class="bi bi-bag-check-fill"></i></button>
                    </td>
                    <td style="padding-top: 3.5rem;padding-left: 2rem;"><a href="<%=request.getContextPath() %>/RemoveCartServlet?id=${c.getId()}"><i class="bi bi-trash-fill"></i></a></td>
                </tr>
               </form>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
</body>
</html>