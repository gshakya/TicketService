<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Success</title>
</head>
<body>
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
                <td>${customerForm.customerName}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${customerForm.customerAddress}</td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td>${customerForm.customerEmail}</td>
            </tr> 
        </table>
    </div>
</body>
</html>