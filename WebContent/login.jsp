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

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>

<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="260184441270-b6iojts9nla7s4i1llcimf5h6clk4to8.apps.googleusercontent.com">

<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/login.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/products.css"%></style>
<style><%@include file="/css/footer.css"%></style>
<title>GensShop</title>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<c:if test="${alert == 'Loginfailed'}">
		<script type="text/javascript">
			alert("Email or Password is incorrect!!");
		</script>
	</c:if>
	<c:if test="${alert == true}">
		<script type="text/javascript">
			alert("Sing Up Success");
		</script>
	</c:if>
	<c:if test="${alert == 'PlaseLogin'}">
		<script type="text/javascript">
			alert("Plase Singin before checkout!!");
		</script>
	</c:if>
	<!-- Login Form -->
	<div
		class="container content-login bg-white o-hidden border-0 shadow-lg my-5 px-4 px-lg-5 mt-5">
		<h3 class="header">Sing In Account</h3>
		<form class="container user" name="loginform" method="post" action="SinginServlet" onsubmit="return loginvalidate()">
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"
					style="font-size: 0.8rem">Email</label> 
					<input type="text"
					class="form-control bg-light" id="Email" name="email"
					placeholder="Enter Email Adress..." onchange="Emailvalidate()"/>
					<span id="checkemail"></span>
			</div>
			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label"
					style="font-size: 0.8rem">Password</label> 
					<input
					type="password" class="form-control bg-light" id="Password" name="password"
					placeholder="Password" onchange="PasswordValidate()"/>
					<span id="checkpass"></span>
			</div>
			<br />
			<!-- <div class="mb-3">
				<div class="g-signin2" data-onsuccess="onSignIn" id="login-google">
				</div>
			</div> -->
			<div class="mb-3">
				<button class="btn btn-primary form-control">Sing In</button>
			</div>
		</form>
		<div class="mb-3" style="text-align: center">
			<a class="sing-up" href="<%=request.getContextPath()%>/SingupServlet">Not a member? Sign up now</a>
		</div>
		<br />
		<br />
	</div>
	<!--End Login Form -->
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
	<script src="./js/AuthenValidate.js"></script>
	<script src="./js/GoogleOauth.js"></script>

</body>
</html>