<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<section class="py-5" style="background: rgb(245, 245, 245)">
	<div class="container px-4 px-lg-5 mt-5">
		<h2 class="fw-bolder mb-4">Related products</h2>
		<br>
		<br>
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items="${relate}" var="c">
				<a
					href="<%=request.getContextPath()%>/ProductDetailServlet?pid=${c.getId()}&&col=${c.getCollection()}&&brand=${c.getBrand()}"
					style="text-decoration: none;">
					<div class="col mb-3">
						<div class="card productsale h-100" style="width: 100%;">
							<c:if test="${c.getStatus()=='onsale'}">
								<div class="bg-danger text-white"
									style="width: 50%; text-align: center;">SALE</div>
							</c:if>
							<c:if test="${c.getStatus()==''}">
								<br>
							</c:if>
							<img src="${c.getImage()}" class="card-img-top" />
							<div class="card-body">
								<p style="color: black;">${c.getTitle()}</p>
								<div class="d-flex" style="color: black;">
									<c:if test="${c.getStatus()=='onsale'}">
										<div style="text-decoration: line-through; color: red;">
											<fmt:formatNumber value="${c.getPrice()}" type="number" />
											Bath
										</div>
		                                &nbsp;&nbsp;&nbsp;
		                                <div>
											<fmt:formatNumber value="${c.getSale()}" type="number" />
											Bath
										</div>
									</c:if>
									<c:if test="${c.getStatus()==''}">
		                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                                <div>
											<fmt:formatNumber value="${c.getPrice()}" type="number" />
											Bath
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<br />
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</section>
