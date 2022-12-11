<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<style><%@include file="/css/login.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>
<title>GensShop</title>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<!-- Register Form -->
	<div
		class="container content-reg bg-white o-hidden border-0 shadow-lg my-5 px-4 px-lg-5 mt-5">
		<h3 class="header">Sing Up Account</h3>
		<form class="container user" name="registerform" method="post"
			action="SingupServlet" onsubmit="return RegisterValidate()">
			<div
				class="row gx-1 gx-lg-1 row-cols-2 row-cols-md-2 row-cols-xl-2 row-cols-xxl-2">
				<div class="col mb-3">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label"
							style="font-size: 0.8rem">Firstname</label> <input type="text"
							class="form-control bg-light" name="fname"
							placeholder="Firstname" /> <span id="checkfname"></span>
					</div>
				</div>
				<div class="col mb-3">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label"
							style="font-size: 0.8rem">Lastname</label> <input type="text"
							class="form-control bg-light" name="lname" placeholder="Lastname" />
						<span id="checklname"></span>
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"
					style="font-size: 0.8rem">Email</label> <input type="text"
					class="form-control bg-light" name="email"
					placeholder="Enter Email Adress..." /> <span id="checkemail"></span>
			</div>
			<div
				class="row gx-1 gx-lg-1 row-cols-2 row-cols-md-2 row-cols-xl-2 row-cols-xxl-2">
				<div class="col mb-3">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label"
							style="font-size: 0.8rem">Password</label> <input type="password"
							class="form-control bg-light" name="password"
							placeholder="Password" /> <span id="checkpass"></span>
					</div>
				</div>
				<div class="col">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label"
							style="font-size: 0.8rem">Repeat Password</label> <input
							type="password" class="form-control bg-light" name="repeatpass"
							placeholder="Repeat Password" /> <span id="checkpass2"></span>
					</div>
				</div>
			</div>
			<br />
			<div class="mb-3">
				<button type="submit" class="btn btn-primary form-control">Sing
					Up</button>
			</div>
		</form>
		<div class="mb-3" style="text-align: center">
			<a class="sing-up" href="<%=request.getContextPath()%>/SinginServlet">Youre
				a member? Sign In now</a>
		</div>
		<br />
		<br />
	</div>
	<!--End Register Form -->
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
	<script src="./js/AuthenValidate.js"></script>

</body>

</html>