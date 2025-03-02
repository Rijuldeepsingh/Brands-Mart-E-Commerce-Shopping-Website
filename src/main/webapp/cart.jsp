<%@page import="brandsmart.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
	response.sendRedirect("index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CART PAGE</title>
<%@include file="includes/head.jsp"%>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: $454</h3>
			<a class="mx-3 btn btn-primary" href="#">Check Out</a>
		</div>
		<table class="table table-light text-center">
			<thead>
				<tr>
					<th scope="col" style="width:20%">Name</th>
					<th scope="col" style="width:20%">Category</th>
					<th scope="col" style="width:20%">Price</th>
					<th scope="col" style="width:20%">Buy Now</th>
					<th scope="col" style="width:20%">Cancel</th>
				</tr>
			</thead>
			<tr>
				<td>Women Shoes</td>
				<td>Shoes</td>
				<td>45$</td>
				<td>
					<form action="" method="post" class="form-inline">
						<input type="hidden" name="id" value="1" class="form-input">
						<div class="form-group d-flex align-item-center">
							<a class="btn btn-sm btn-dcre"><i class="fas fa-minus-square"></i></a>
							<input type="text" name="quantity" class="form-control-sm text-center mx-2" value="1" readonly> 
							<a class="btn btn-sm btn-incre"><i class="fas fa-plus-square"></i></a>		
						</div>
					</form>
				</td>
				<td><a class="btn btn-sm btn-danger" href="#">Remove</a></td>
			</tr>

		</table>
	</div>
	<%@include file="includes/footer.jsp"%>

</body>
</html>