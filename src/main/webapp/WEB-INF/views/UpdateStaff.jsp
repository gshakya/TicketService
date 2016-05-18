<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Staff</title>
</head>
<body>

	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input class="btn btn-primary" type="submit" value="Logout" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<a href="${pageContext.request.contextPath}/admin"> Admin Dashboard </a>
	</sec:authorize>

	<form action="${pageContext.request.contextPath}/staff/updateStaff"
		method="post">
		<h1>Update Staff</h1>
		<br> Staff Name <input type="text" name="staffName" value=>
		<br> Staff Address <input type="text" name="staffAddress">
		<br> Staff Email <input type="text" name="staffEmail"> <br>
		<input type="submit" value="Save">
	</form>
</body>
</html>