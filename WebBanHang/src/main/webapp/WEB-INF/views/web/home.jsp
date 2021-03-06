<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="container">
		<div class="products">
			<h2 class=" products-in">PRODUCTS</h2>
			<div class=" top-products">
				<c:forEach var="product" items="${product}">
					<div class="col-md-3 md-col">
						<div class="col-md">
							<a href="#" class="compare-in"><img
								src="<c:url value="/anh/abc.jpg"/>" alt="" /> </a>
							<div class="top-content">
								<h5>
									<a href="#">${product.name}</a>
								</h5>
								<div class="white">
									<a href='<c:url value="/cart/add/${product.id}"/>'
										class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD
										TO CART</a>
									<p class="dollar">
										<span class="in-dollar">$</span><span>${product.price}</span>
									</p>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				${pageContext.request.requestURL}<br>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->
</body>
</html>