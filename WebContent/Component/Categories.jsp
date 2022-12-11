<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<ul class="navbar-nav me-auto mb-2 mb-lg-0">
		<li class="nav-item"><a class="nav-link active" name="shopall"
			aria-current="page"
			href="<%=request.getContextPath()%>/AllProductServlet?header=Shop All&&page=1">Shop
				All</a></li>
		<c:forEach items="${cat}" var="c">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
				data-bs-toggle="dropdown" aria-expanded="false">
					${c.getCollection()} </a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<c:forEach items="${brand}" var="b">
						<li><c:if test="${b.getCollection() == c.getCollection()}">
								<li><a class="dropdown-item"
									href="<%=request.getContextPath()%>/ProductsCollectionServlet?header=${c.getCollection()}/${b.getBrand()}&&col=${c.getCollection()}&&brand=${b.getBrand()}&&page=1">
										${b.getBrand()} </a></li>
							</c:if></li>
					</c:forEach>
				</ul></li>
		</c:forEach>

		<li class="nav-item"><a class="nav-link active"
			aria-current="page"
			href="<%=request.getContextPath()%>/OnsaleProductServlet?header=On Sale&&page=1">Sales</a>
		</li>
	</ul>
</nav>
