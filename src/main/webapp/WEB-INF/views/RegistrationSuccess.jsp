<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
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
	content: '';
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
</style>
</head>
<body>
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600'
		rel='stylesheet' type='text/css'>
	<link
		href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css"
		rel="stylesheet">
<div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>Registration Succeeded!</h2></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <h3>Thank you for registering! Here's the review of your details:</h3>
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${customerForm.name}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${customerForm.address}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${customerForm.email}</td>
            </tr> 
            <tr>
                <td>User name:</td>
                <td>${customerForm.userInfo.username}</td>
            </tr> 
            <tr>
              <td>
               <a href="${pageContext.request.contextPath}/">Home</a>
               </td>
            </tr> 
        </table>
    </div>
</body>
</html>