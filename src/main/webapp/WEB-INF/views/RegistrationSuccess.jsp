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