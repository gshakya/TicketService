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
<style>
body {
	background: #fafafa
		url(http://jackrugile.com/images/misc/noise-diagonal.png);
	color: #444;
	font: 100%/30px 'Helvetica Neue', helvetica, arial, sans-serif;
	text-shadow: 0 1px 0 #fff;
}

strong {
	font-weight: bold;
}

em {
	font-style: italic;
}

table {
	background: #f5f5f5;
	border-collapse: separate;
	box-shadow: inset 0 1px 0 #fff;
	font-size: 20px;
	line-height: 24px;
	margin: 30px auto;
	text-align: left;
	width: 800px;
}

th {
	background: url(http://jackrugile.com/images/misc/noise-diagonal.png),
		linear-gradient(#777, #444);
	border-left: 1px solid #555;
	border-right: 1px solid #777;
	border-top: 1px solid #555;
	border-bottom: 1px solid #333;
	box-shadow: inset 0 1px 0 #999;
	color: #fff;
	font-weight: bold;
	padding: 10px 15px;
	position: relative;
	text-shadow: 0 1px 0 #000;
}

th:after {
	background: linear-gradient(rgba(255, 255, 255, 0),
		rgba(255, 255, 255, .08));
	content: "";
	display: block;
	height: 25%;
	left: 0;
	margin: 1px 0 0 0;
	position: absolute;
	top: 25%;
	width: 100%;
}

th:first-child {
	border-left: 1px solid #777;
	box-shadow: inset 1px 1px 0 #999;
}

th:last-child {
	box-shadow: inset -1px 1px 0 #999;
}

td {
	border-right: 1px solid #fff;
	border-left: 1px solid #e8e8e8;
	border-top: 1px solid #fff;
	border-bottom: 1px solid #e8e8e8;
	padding: 10px 15px;
	position: relative;
	transition: all 300ms;
}

td:first-child {
	box-shadow: inset 1px 0 0 #fff;
	text-align: right;
	width: 30%;
}

td:last-child {
	border-right: 1px solid #e8e8e8;
	box-shadow: inset -1px 0 0 #fff;
}

tr {
	background: url(http://jackrugile.com/images/misc/noise-diagonal.png);
}

tr:nth-child(odd) td {
	background: #f1f1f1
		url(http://jackrugile.com/images/misc/noise-diagonal.png);
}

tr:last-of-type td {
	box-shadow: inset 0 -1px 0 #fff;
}

tr:last-of-type td:first-child {
	box-shadow: inset 1px -1px 0 #fff;
}

tr:last-of-type td:last-child {
	box-shadow: inset -1px -1px 0 #fff;
}

tbody:hover td {
	color: transparent;
	text-shadow: 0 0 3px #aaa;
}

tbody:hover tr:hover td {
	color: #444;
	text-shadow: 0 1px 0 #fff;
}

.button {
	font-size: 14px;
	font-weight: 600;
	color: white;
	padding: 6px 25px 0px 20px;
	margin: 10px 8px 20px 0px;
	display: inline-block;
	float: right;
	text-decoration: none;
	/*  width: 50px; height: 27px;  */
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	background-color: #3a57af;
	-webkit-box-shadow: 0 3px rgba(58, 87, 175, .75);
	-moz-box-shadow: 0 3px rgba(58, 87, 175, .75);
	box-shadow: 0 3px rgba(58, 87, 175, .75);
	transition: all 0.1s linear 0s;
	top: 0px;
	position: relative;
}

.button:hover {
	top: 3px;
	background-color: #2e458b;
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	box-shadow: none;
}

input[type=text], input[type=password] {
	width: 300px;
	height: 39px;
	-webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	-moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px;
	border-radius: 0px 4px 4px 0px/5px 5px 4px 4px;
	background-color: #fff;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 1px #cbc9c9;
	margin-left: -5px;
	margin-top: 13px;
	padding-left: 10px;
}

#icon {
	display: inline-block;
	width: 30px;
	background-color: #3a57af;
	padding: 12px 0px 12px 15px;
	margin-left: 15px;
	-webkit-border-radius: 4px 0px 0px 4px;
	-moz-border-radius: 4px 0px 0px 4px;
	border-radius: 4px 0px 0px 4px;
	color: white;
	-webkit-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	-moz-box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	box-shadow: 1px 2px 5px rgba(0, 0, 0, .09);
	border: solid 0px #cbc9c9;
}

.error {
	color: red;
}

.home {
	text-decoration: none;
	margin-left: 15px;
}

.home .icon-home {
	font-size: 3em;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
		rel='stylesheet' type='text/css'>
	<link
		href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
		rel="stylesheet">
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input class="btn btn-primary" type="submit" value="Logout" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<a href="${pageContext.request.contextPath}/admin"> Admin
			Dashboard </a>
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