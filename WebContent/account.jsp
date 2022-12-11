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
<title>GensShop</title>
<style><%@include file="/css/navbar.css"%></style>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/footer.css"%></style>
<style><%@include file="/css/profile.css"%></style>
</head>
<body>
	<!-- Navbar -->
	<%@ include file="./Component/Navbar.jsp"%>
	<c:if test="${alert == false}">
		<script type="text/javascript">
			alert("Update User Account Failed!!");
		</script>
	</c:if>
	<c:if test="${alert == true}">
		<script type="text/javascript">
		alert("Update User Account Successfull!!");
		</script>
	</c:if>
	<div class="container my-5 px-4 px-lg-5 mt-5 o-hidden border-0 shadow-lg" style="max-width: 60rem;">
        <form class="profile" action="AccountServlet" method="post" name="account" onsubmit="return UserValidate()">
            <div class="row gutters">
            <c:forEach items="${user}" var="u">
                <div class="col-xl-3 col-lg-3 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="account-settings">
                                <div class="user-profile" style="padding-top:30%">
                                    <div class="user-avatar">
                                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Maxwell Admin" />
                                    </div>
                                    <h5 class="user-name">${u.getFname()} ${u.getLname()}</h5>
                                    <h6 class="user-email">${u.getEmail()}</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                <div class="col-xl-9 col-lg-9 col-md-12 col-sm-12 col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mb-2 text-primary">Personal Details</h6>
                                </div>
                                <c:forEach items="${user}" var="u">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="Firstname">Firstname</label>
                                        <input type="text" class="form-control" name="fname" placeholder="Enter firstname" value="${u.getFname()}" />
                                        <span id="fname"></span>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="Lastname">Lastname</label>
                                        <input type="text" class="form-control" name="lname" placeholder="Enter lastname" value="${u.getLname()}" />
                                        <span id="checklname"></span>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="Email">Email</label>
                                        <input type="text" class="form-control" name="email" value="${u.getEmail()}" placeholder="Enter phone number" />
                                        <span id="checkemail"></span>
                                    </div>
                                </div>
                                </c:forEach> 
                                <c:forEach items="${book}" var="b">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
	                                     <label>Phone</label>
	                                     <input type="text" class="form-control" name="phone" placeholder="Phone" value="${b.getPhone()}" />
	                                     <span id="checkphone"></span>
                                    </div>
                                </div> 
                                </c:forEach>
                            </div>
                            <div class="row gutters">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                                    <h6 class="mt-3 mb-2 text-primary">Address</h6>
                                </div>
                                <c:forEach items="${book}" var="b">
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="Street">Street</label>
                                        <input type="text" class="form-control" id="Street" name="street" placeholder="Enter Street" value="${b.getStreet()}" />
                                        <span id="checkstreet"></span>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="ciTy">City</label>
                                        <input type="text" class="form-control" id="ciTy" name="city" placeholder="Enter City" value="${b.getCity()}" />
                                        <span id="checkcity"></span>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="sTate">State</label>
                                        <input type="text" class="form-control" id="sTate" name="state" placeholder="Enter State" value="${b.getState()}" />
                                        <span id="checkstate"></span>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-6 col-12">
                                    <div class="form-group">
                                        <label htmlFor="zIp">Zip Code</label>
                                        <input type="text" class="form-control" id="zIp" name="zipcode" placeholder="Zip Code" value="${b.getZipcode()}" />
                                        <span id="checkzipcode"></span>
                                    </div>
                                </div>
                                </c:forEach>
                            </div><br />
                            <div class="row gutters">
                                <div class="text-right">
                                        <button type="submit" name="submit" class="btn btn-primary form-control bg-primary text-light">Update</button>
                                 </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
	<!-- Footer -->
	<%@ include file="./Component/Footer.jsp"%>
	<script src="./js/UserAccountValidate.js"></script>
</body>
</html>