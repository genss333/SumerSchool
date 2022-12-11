<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-end">
		<c:forEach var="i" begin="1" end="${pgpage}">
			<li class="page-item"><a class="page-link"
				href="<c:out value = "${location}"/><c:out value = "${i}"/>"> <c:out
						value="${i}" />
			</a></li>
		</c:forEach>
	</ul>
</nav>
