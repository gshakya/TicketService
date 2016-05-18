<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List</title>
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

	<form action="${pageContext.request.contextPath}/customer/findCustomer"
		method="get">
		<h1>Find Customer</h1>
		<h3>${errorMessage}</h3>
		<br> Customer Name <input type="text" name="customerName">
		<br> Customer Email <input type="text" name="customerEmail">
		<input type="submit" value="Find"> <br> <a
			href="${pageContext.request.contextPath}/customer/addCustomer">New
			Customer</a>
	</form>
	<br>
	<table cellpadding="6px" bordercolor="black">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Address</td>
			<td>Email</td>
			<td>User Name</td>
			<td></td>
		</tr>
		<tr>
		</tr>
		<c:forEach items="${customers}" var="customer">

			<tr id="tr{customer.id}">
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.address}</td>
				<td>${customer.email}</td>
				<td>${customer.userInfo.username}</td>

				<td><input onclick="update(${customer.id})" type="submit"
					value="Update"></td>
				<td id="td${customer.id}"><input
					onclick="removeCustomer(${customer.id})" type="submit"
					value="Delete"></td>
			</tr>
		</c:forEach>
	</table>
	<form:form>

	</form:form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script type="text/javascript">
function  update(id){

	window.location.href = "${pageContext.request.contextPath}/customer/updateCustomer/"+id;
 }

function  removeCustomer(id){
	$.ajax({type : "GET",
		contentType:"application/json; charset=utf-8",
		url : "${pageContext.request.contextPath}/customer/removeCustomer/"+id,
		success : function(response) {
			$("#td"+id).closest("tr").empty();
		}
	}); 
 }
</script>
</body>
</html>