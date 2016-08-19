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
					<th>ID</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Total</th>
				</tr>
			</thead>
			<c:forEach items="${billdetailBeans}" var="element">
				<tr>
					<td class="invert">${element.id}</td>
					<td class="invert">${element.pname}</td>
					<td class="invert">${element.quanlity}</td>
					<td class="invert">${element.total}</td>
				</tr>
				<c:set var="billidnamana" scope="session" value="${element.bid}"/>
			</c:forEach>
		</table>
		<form action="admin">
			<input type="hidden" name="method" value="changestt">
			<input type="hidden" name="billid" value="${billidnamana}">
			Status: <input type="text" name="stt" placeholder="New status here">
		<input type="submit" value="Change"/>
		</form>
	</div>
</body>
</html>