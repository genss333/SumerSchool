<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<%@ include file="Contract.jsp"%>
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="brand"
						href="<%=request.getContextPath()%>/IndexServlet"
						style="margin-left: 5rem;">GensShop</a></li>
					<li class="nav-item">
						<form class="d-flex"
							action="ProductSerchServlet?header=Search Products&&page=1"
							method="post" style="margin-left: 1rem; margin-top: .3rem;">
							<input class="form-control me-2" type="search" name="search"
								placeholder="Search" aria-label="Search" required="required">
							<button class="btn btn-primary" type="submit">Search</button>
						</form>
					</li>
				</ul>
				<ul class="nav justify-content-end">
					<li class="nav-item"
						style="margin-top: .5rem; margin-right: 2.5rem;">
						<c:forEach
							items="${user}" var="u">
							<div class="dropdown">
								<div dropdown-toggle" href="#" role="button"
									id="dropdownMenuLink" data-bs-toggle="dropdown"
									aria-expanded="false">
									<i class="bi bi-person-fill"></i> &nbsp;&nbsp;<span>${u.getFname()}
										${u.getLname()}</span>
								</div>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
									<li><a class="dropdown-item"
										href="<%=request.getContextPath()%>/AccountServlet">Account</a></li>
									<li><a class="dropdown-item"
										href="<%=request.getContextPath()%>/OrderServlet?header=order&&page=1">Your
											Order</a></li>
									<li><a class="dropdown-item"
										href="<%=request.getContextPath()%>/SingoutServlet">Sing
											Out</a></li>
								</ul>
							</div>
						</c:forEach>
							<c:if test="${g_email != null}">
								<div class="dropdown">
									<div dropdown-toggle" href="#" role="button"
										id="dropdownMenuLink" data-bs-toggle="dropdown"
										aria-expanded="false">
										<img alt="" src="${g_pic}"> &nbsp;&nbsp;<span>${g_name}</span>
									</div>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
										<li><a class="dropdown-item"
											href="<%=request.getContextPath()%>/AccountServlet">Account</a></li>
										<li><a class="dropdown-item"
											href="<%=request.getContextPath()%>/OrderServlet?header=order&&page=1">Your
												Order</a></li>
										<li><a class="dropdown-item"
											href="<%=request.getContextPath()%>/SingoutServlet">Sing
												Out</a></li>
									</ul>
								</div>
							</c:if>
						</li>
						<%
						if (session.getAttribute("Username") == null && session.getAttribute("g-user") == null ) {
						%>
						<li class="nav-item" style="margin-right: 2rem;"><a
							class="nav-link text-black"
							href="<%=request.getContextPath()%>/SinginServlet">Sing In</a>
						</li>
						<%
						}
						%>
					<a href="<%=request.getContextPath()%>/CartServlet" class="nav-item"
						style="margin-right: 5rem; margin-top: .3rem; text-decoration: none; color: #000;">
						<svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
							fill="currentColor" class="bi bi-cart3" viewBox="0 0 16 16">
                                <path
								d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .49.598l-1 5a.5.5 0 0 1-.465.401l-9.397.472L4.415 11H13a.5.5 0 0 1 0 1H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l.84 4.479 9.144-.459L13.89 4H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
                            </svg> <span
						class="osition-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
							<c:out value="${qty}"></c:out>
						</span>
					</a>
				</ul>
			</div>
		</div>
	</nav>
	<%@ include file="Categories.jsp"%>
</div>
