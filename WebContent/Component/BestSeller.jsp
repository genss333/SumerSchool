<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<div
		class="container-xxl bg-white o-hidden border-0 shadow-lg my-5 px-4 px-lg-5 mt-5">
		<h1 class="header" style="text-align: center;">Best Seller</h1>
		<div
			class="row gx-4 gx-lg-4 row-cols-2 row-cols-md-2 row-cols-xl-4 row-cols-xxl-4
                justify-content-center"
			style="margin-bottom: 4rem;">
			<c:forEach items="${best}" var="p">
				<a
					href="<%=request.getContextPath()%>/ProductDetailServlet?pid=${p.getId()}&&col=${p.getCollection()}&&brand=${p.getBrand()}"
					style="text-decoration: none;">
					<div class="col mb-3">
						<div class="card productsale h-100" style="width: 100%;">
							<div class="bg-danger text-white"
								style="width: 50%; text-align: center;">SALE</div>
							<img src="${p.getImage()}" class="card-img-top" />
							<div class="card-body">
								<p class="fw-bolder product-title" style="color: black;">${p.getTitle()}</p>
								<div class="d-flex" style="color: black;">
									<div style="text-decoration: line-through; color: red;">
										<fmt:formatNumber value="${p.getPrice()}" type="number" />
										Bath
									</div>
									&nbsp;&nbsp;&nbsp;
									<div>
										<fmt:formatNumber value="${p.getSale()}" type="number" />
										Bath
									</div>
								</div>
							</div>
						</div>
						<br />
					</div>
				</a>
			</c:forEach>
		</div>
		<div class="container" style="width: 120px;">
			<a class="btn btn-primary viewall"
				href="bestseller?header=Best Seller&&page=1">View All</a>
		</div>
	</div>
</div>
