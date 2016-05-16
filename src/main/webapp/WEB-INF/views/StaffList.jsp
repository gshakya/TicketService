<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff List</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/staff/findStaff" method="get">
		<h1>Find Staff</h1>
		<br> Staff Name 
		<input type="text" name="staffName"> 
		<br> Staff Email 
		<input type="text" name="staffEmail">
		<input type="submit" value="Find">
	</form>
</body>
</html>