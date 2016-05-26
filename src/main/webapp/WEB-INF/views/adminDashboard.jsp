<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
<style>
.round-button {
	width: 33.33%;
}

.round-button-circle {
	width: 100%;
	height: 0;
	padding-bottom: 100%;
	border-radius: 50%;
	border: 10px solid #cfdcec;
	overflow: hidden;
	background: #4679BD;
	box-shadow: 0 0 3px gray;
}

.round-button-circle:hover {
	background: #30588e;
}

.round-button a {
	display: block;
	float: left;
	width: 100%;
	padding-top: 50%;
	padding-bottom: 50%;
	line-height: 1em;
	margin-top: -0.5em;
	text-align: center;
	color: #e2eaf3;
	font-family: Verdana;
	font-size: 1.2em;
	font-weight: bold;
	text-decoration: none;
}

.float-left {
	float: left;
}

.type2 {
	background: #ECA215;
}

.type2:hover {
	background: #EC9004;
}

.type3 {
	background: #EC4F04;
}

.type3:hover {
	background: #F53B03;
}

body {
	margin: 0 auto;
	padding: 0;
	background: #9d261d
}

h1, h2, h3 {
	color: #ffffff;
}

.container {
	position: relative;
	top: 10%;
	width: 1000px;
	text-align: center;
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="round-button float-left">
		<div class="round-button-circle">
			<a href="staff">Staff List</a>
		</div>
	</div>

	<div class="round-button float-left">
		<div class="round-button-circle type2">
			<a href="register">Register</a>
		</div>
	</div>
	<div class="round-button float-left">
		<div class="round-button-circle type3">
			<a href="customer">Customer List</a>
		</div>
	</div>
	<div class="round-button float-left">
		<div class="round-button-circle">
			<a href="movie">Movie List</a>

		</div>
	</div>
</body>
</html>