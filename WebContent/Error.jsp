<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<div>
		<div class="container-xxl bg-white o-hidden border-0  my-5">
			<div
				class="row gx-2 gx-lg-2 row-cols-2 row-cols-md-2 row-cols-xl-4 row-cols-xxl-4 justify-content-end bestprice">
				<div class="parallelogram bg-white o-hidden border-0 shadow-lg">
					<h1>Error!</h1>
					<p>
						List of errors:<br /> The list goes here: <br /> - ... <br /> -
						... <br />
						<c:out value="${exception}"></c:out>
						<%
						if (exception != null) {
							out.print(exception);
						}
						%>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
