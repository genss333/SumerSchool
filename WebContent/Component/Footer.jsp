<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<footer class="site-footer bg-light">
		<div class="container">
			<div
				class="row gx-4 gx-lg-4 row-cols-2 row-cols-md-3 row-cols-xl-3 row-cols-xxl-3">
				<div class="col-sm-12 col-md-6">
					<h6>About</h6>
					<p class="text-justify">
						Scanfcode.com <i>CODE WANTS TO BE SIMPLE </i> is an initiative to
						help the upcoming programmers with the code. Scanfcode focuses on
						providing the most efficient code or snippets as the code wants to
						be simple. We will help programmers build up concepts in different
						programming languages that include C, C++, Java, HTML, CSS,
						Bootstrap, JavaScript, PHP, Android, SQL and Algorithm.
					</p>
				</div>

				<div class="col-xs-6 col-md-3">
					<h6>Categories</h6>
					<ul class="footer-links">
						<li><a>Shop All</a></li>
						<c:forEach items="${cat}" var="c">
							<li><a>${c.getCollection()}</a></li>
						</c:forEach>

						<li><a>Sales</a></li>
					</ul>
				</div>

				<div class="col-xs-6 col-md-3">
					<h6>Quick Links</h6>
					<ul class="footer-links">
						<li><a href="http://scanfcode.com/about/">About Us</a></li>
						<li><a href="http://scanfcode.com/contact/">Contact Us</a></li>
						<li><a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a></li>
						<li><a href="http://scanfcode.com/privacy-policy/">Privacy
								Policy</a></li>
						<li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>
					</ul>
				</div>
			</div>
			<hr>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-sm-6 col-xs-12">
					<p class="copyright-text">
						Copyright &copy; 2017 All Rights Reserved by <a href="#">Scanfcode</a>.
					</p>
				</div>

				<div class="col-md-4 col-sm-6 col-xs-12">
					<ul class="social-icons">
						<li><a class="twitter" href="#"><i class="bi bi-twitter"></i></a></li>
						<li><a class="dribbble" href="#"><i
								class="bi bi-facebook"></i></a></li>
						<li><a class="linkedin" href="#"><i
								class="bi bi-linkedin"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</div>
