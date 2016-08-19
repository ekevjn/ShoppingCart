<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-8 w3ls_dresses_grid_right">
		<div class="clearfix"></div>

		<div class="w3ls_dresses_grid_right_grid2">
			<div class="clearfix"></div>
		</div>
		<table class="timetable_sub">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Price</th>
					<th>Description</th>
					<th>Add</th>
				</tr>
			</thead>
			<c:forEach items="${pBean.pList}" var="element">
				<tr>
					<td class="invert">${element.cname}</td>
					<td class="invert">${element.price}</td>
					<td class="invert">${element.description}</td>
					<td class="invert"><p><a class="item_add" href="/add2cart?pId=${element.id}&method=add">Add to cart</a></p></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>