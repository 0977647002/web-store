<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="header">
		<div class="header-top">
			<div class="container">
				<div class="header-top-in">
					<div class="logo">
						<a href="#"><img src="<c:url value="/anh/logo.png"/>" alt=""></a>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">
							<li><a href="#">WISH LIST (0)</a></li>
							<li><a href="#"> MY ACCOUNT</a></li>
							<li><a href="#"> SHOPPING CART</a></li>
							<li><a href="#">CHECKOUT</a></li>
							<li><div class="cart">
									<a href="#" class="cart-in"><img
										src="<c:url value="/anh/cart.png"/>" alt=""></a><span>${sessionScope.myCartNum}</span>
								</div>
								<ul class="sub-icon1 list">
									<h3>Recently added items(${sessionScope.myCartNum})</h3>
									<div class="shopping_cart">
										<c:forEach var="map" items="${sessionScope.myCartItems}">
											<div class="cart_box">
												<div class="message">
													<div class="alert-close"></div>
													<div class="list_img">
														<img
															src="${pageContext.request.contextPath}/resources/pages/images/14.jpg"
															class="img-responsive" alt="">
													</div>
													<div class="list_desc">
														<h4>
															<a href="#"><c:out
																	value="${map.value.product.name}" /></a>
														</h4>
														<c:out value="${map.value.quantity}" />
														x $
														<c:out value="${map.value.product.price}" />
														= <span class="actual"> $<c:out
																value="${map.value.quantity * map.value.product.price}" /></span>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
										</c:forEach>
										<div class="total_left">CartSubtotal :</div>
										<div class="total_right">${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}</div>
										<div class="clearfix"></div>
									</div>
									<div class="login_buttons">
										<div class="check_button">
											<a href='<c:url value="/checkout"/>'>Check out</a>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</ul></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="/"><i> </i>HOME</a></li>
					<c:forEach var="category" items="${category}">
						<li><a href="<c:url value="/category/${category.url}/${category.id}"/>">${category.name}</a>
					</c:forEach>
				</ul>
				<script type="text/javascript" src="js/nav.js"></script>
			</div>
		</div>
	</div>
	</div>
</body>
</html>