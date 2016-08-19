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
	<div class="col-md-8 w3ls_dresses_grid_right" id="cusmanagetable">
		<div class="clearfix"></div>

		<div class="w3ls_dresses_grid_right_grid2">
			<div class="clearfix"></div>
		</div>
		<table class="timetable_sub">
			<thead>
				<tr>
					<th>UserName</th>
					<th>Full Name</th>
					<th>RollNumber</th>
				</tr>
			</thead>
			<c:forEach items="${loginBeans}" var="element">
				<tr>
					<td class="invert">${element.userName}</td>
					<td class="invert">${element.fullname}</td>
					<td class="invert">${element.rollnumber}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
<style>
/* #cusmanagetable {
    display: none;
} */
</style>
</html>