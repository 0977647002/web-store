<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="card mt-4">
		<img class="card-img-top img-fluid"
			src="<c:url value="/anh/abc.jpg"/>" alt="">
		<div class="card-body">
			<h3 class="card-title">${product.name}</h3>
			<h4>${product.price}</h4>
			<p class="card-text">${product.description}</p>
			<span class="text-warning">&#9733; &#9733; &#9733; &#9733;
				&#9734;</span> 4.0 stars
		</div>
	</div>
	<!-- /.card -->

	<div class="card card-outline-secondary my-4">
		<div class="card-header">Product Reviews</div>
		<div class="card-body">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Omnis et enim aperiam inventore, similique necessitatibus neque non!
				Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi
				mollitia, necessitatibus quae sint natus.</p>
			<small class="text-muted">Posted by Anonymous on 3/1/17</small>
			<hr>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Omnis et enim aperiam inventore, similique necessitatibus neque non!
				Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi
				mollitia, necessitatibus quae sint natus.</p>
			<small class="text-muted">Posted by Anonymous on 3/1/17</small>
			<hr>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Omnis et enim aperiam inventore, similique necessitatibus neque non!
				Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi
				mollitia, necessitatibus quae sint natus.</p>
			<small class="text-muted">Posted by Anonymous on 3/1/17</small>
			<hr>
			<a href="#" class="btn btn-success">Leave a Review</a>
		</div>
	</div>
	<!-- /.card -->


</body>
</html>