<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form action="${pageContext.request.contextPath}/register" method="post" >
		<h1>Register now</h1>
		<br> Name 
		<input type="text" name="customerName"> 
		<br> Address 
		<input type="text" name="customerAddress">
		<br> Email 
		<input type="text" name="customerEmail">
		<input type="submit" value="Register">
	</form>
</body>
</body>
</html>