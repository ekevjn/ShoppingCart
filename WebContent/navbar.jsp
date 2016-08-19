<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Beans.LoginBean" %>
<jsp:useBean id="accountBean" scope="session" class="Beans.LoginBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%-- <jsp:setProperty property="*" name="accountBean"/> --%>
	Hello: <h2><jsp:getProperty property="userName" name="accountBean"/></h2>
	<a href="/logout">Logout</a>
</body>
</html>