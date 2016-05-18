<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staff List</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/staff/findStaff" method="get">
		<h1>Find Staff</h1>
		<h3>${errorMessage}</h3>
		<br> Staff Name <input type="text" name="staffName"> 
		<br> Staff Email <input type="text" name="staffEmail">
		<input type="submit" value="Find">
		<br> <a href="${pageContext.request.contextPath}/staff/addStaff">New Staff</a>
	</form>
	<br>
	<table cellpadding="6px" bordercolor="black">
		<tr>
		<!-- 	<td >Id</td> -->
			<td>Name</td>
			<td>Address</td>
			<td>Email</td>
			<td></td>
		</tr>
		<tr> </tr>
		<c:forEach items="${staffs}" var="staff">

			<tr id="tr{staff.id}" >
			<%-- 	<td>${staff.id}</td> --%>
				<td>${staff.name}</td>
				<td>${staff.address}</td>
				<td>${staff.email}</td>
				
				<td><input onclick="update(${staff.id})" type="submit" value="Update"></td>
				<td id="td${staff.id}"><input onclick="removeStaff(${staff.id})" type="submit" value="Delete"></td>
			</tr>
		</c:forEach>		
	</table>
<form:form>
	
</form:form>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script> 
	<script type="text/javascript">
function  update(id){

	window.location.href = "${pageContext.request.contextPath}/staff/updateStaff/"+id;
 }

function  removeStaff(id){
	$.ajax({type : "GET",
		contentType:"application/json; charset=utf-8",
		url : "${pageContext.request.contextPath}/staff/removeStaff/"+id,
		success : function(response) {
			$("#td"+id).closest("tr").empty();
		}
	}); 
 }
</script>	
</body>
</html>