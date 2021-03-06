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
		<div class="content">
			<div class="shopping_cart">
				<hr>
				<p>
					<c:if test="${not empty messenger}">${messenger}</c:if>
				</p>
				<c:forEach var="map" items="${sessionScope.myCartItems}">
					<div class="cart_box">
						<div class="message">
							<div class="list_img">
								<img src="<c:url value="/anh/abc.jpg"/>" class="img-responsive"
									alt="">
							</div>
							<div class="list_desc">
								<h4>
									<a href="#"><c:out value="${map.value.product.name}" /></a>
								</h4>
								<c:out value="${map.value.quantity}" />
								x $
								<c:out value="${map.value.product.price}" />
								= <span class="actual"> $<c:out
										value="${map.value.quantity * map.value.product.price}" /></span>
								<hr>
								<div class="list_close">
									<a href='<c:url value="/cart/remove/${map.value.product.id}"/>'>Remove
										item</a>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="total">
				<div class="total_right">Free Shipping</div>
				<div class="clearfix"></div>
				<div class="total_right">
					Total: $
					<c:out value="${sessionScope.myCartTotal}" />
				</div>
				<div class="clearfix"></div>
				<div class="total_right">
					VAT (10%):
					<c:out value="${sessionScope.myCartTotal * 0.1}" />
				</div>
				<div class="clearfix"></div>
				<div class="total_right">
					Pay: $
					<c:out
						value="${sessionScope.myCartTotal + (sessionScope.myCartTotal * 0.1)}" />
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
	</div>
	<hr>
	<div class="container">
		<div class="contact">
			<h2 class=" contact-in">CONTACT</h2>

			<div class="col-md-6 contact-top">
				<h3>Info</h3>
				<div class="map">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d37494223.23909492!2d103!3d55!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x453c569a896724fb%3A0x1409fdf86611f613!2sRussia!5e0!3m2!1sen!2sin!4v1415776049771"></iframe>
				</div>

				<p>At vero eos et accusamus et iusto odio dignissimos ducimus
					qui blanditiis praesentium voluptatum deleniti atque corrupti quos
					dolores et quas</p>
				<p>Et harum quidem rerum facilis est et expedita distinctio. Nam
					libero tempore, cum soluta nobis est eligendi optio cumque nihil
					impedit quo minus id</p>
				<ul class="social ">
					<li><span><i> </i>124 Avenue Street, Los
							angeles,California </span></li>
					<li><span><i class="down"> </i>+ 00 123 456 7890</span></li>
					<li><a href="mailto:info@example.com"><i class="mes">
						</i>info@example.com</a></li>
				</ul>
			</div>
			<div class="col-md-6 contact-top">
				<form method="POST"
					action='<c:url value="/cart/checkout"/>'
					>
					<h3>Want to work with me?</h3>
					<div>
						<span>Your Name</span>
						<input type="text" value="" name="name"/>
					</div>
					<div>
						<span>Your Email</span>
						<input type="text" value="" name="email" />
					</div>
					<div>
						<span>Your Address</span>
						<input type="text" value="" name="address" />
					</div>
					<input type="submit" value="SEND">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</body>
</html>