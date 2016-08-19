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
					<th>Bill ID</th>
					<th>Customer Name</th>
					<th>Date</th>
					<th>Total</th>
					<th>Status</th>
					<th>View</th>
				</tr>
			</thead>
			<c:forEach items="${cusbillBeans}" var="element">
				<tr>
					<td class="invert">${element.id}</td>
					<td class="invert">${element.cusName}</td>
					<td class="invert">${element.createdDate}</td>
					<td class="invert">${element.totalbill}</td>
					<td class="invert">${element.status}</td>
					<td class="invert"><p><a class="item_add" href="/admin?method=billdetail&billid=${element.id}">Details</a></p></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>