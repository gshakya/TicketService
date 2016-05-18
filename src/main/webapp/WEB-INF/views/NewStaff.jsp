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
<title>New/Update Staff</title>
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

	<form:form action="${pageContext.request.contextPath}/staff/${page}"
		method="POST" commandName="staff">

		<form:hidden path="id" />
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Staff Name</label>
					<div>
						<form:input path="name" class="form-control" name="name"
							data-parsley-required="true" data-parsley-trigger="change"
							placeholder="Staff Name" />
					</div>
				</div>

				<div class="form-group">
					<label>Staff Password</label>
					<div>
						<form:input path="userInfo.password" class="form-control"
							name="password" data-parsley-required="true"
							data-parsley-trigger="change" placeholder="Login password" />
					</div>
				</div>

				<div class="form-group">
					<label>Staff Address</label>
					<div>
						<form:input path="address" class="form-control" name="address"
							data-parsley-type="address" data-parsley-required="true"
							data-parsley-trigger="change"
							placeholder="805 N Main street, Fairfield, IA, 52556" />
					</div>
				</div>
				<div class="form-group">
					<label>Staff Email</label>
					<div>
						<form:input path="email" class="form-control" name="email"
							data-parsley-type="email" data-parsley-required="true"
							data-parsley-trigger="change" placeholder="hello@mum.edu" />
					</div>
				</div>


				<div class="form-group">
					<label>Login name</label>
					<div>
						<form:input path="userInfo.username" class="form-control"
							name="userInfo.username" data-parsley-required="true"
							data-parsley-trigger="change" placeholder="yourusername" />
					</div>
				</div>
				<!-- Role = RegisteredViewer?????? -->

				<form:hidden path="userInfo.role" value="${RegisteredViewer}" />


				<div class="form-group text-center">
					<label></label>
					<div>
						<input type="submit" value="Save"
							class="btn btn-primary btn-block btn-lg btn-parsley" />
					</div>
				</div>

			</div>
		</div>
	</form:form>
</body>
</html>