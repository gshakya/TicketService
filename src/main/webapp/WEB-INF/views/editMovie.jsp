<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix = "sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie Utility</title>
</head>
<body>
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<a href="${pageContext.request.contextPath}/admin"> Admin Dashboard </a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input class="btn btn-primary" type="submit" value="Logout" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</sec:authorize>
	<h1>Movie Utility</h1>
	<form:form id='formedit' method="POST" commandName="movie"
		action="${pageContext.request.contextPath}/movie/edit">
		<form:hidden path="movieId" />
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Movie name</label>
					<div>
						<form:input path="movieName" class="form-control" name="movieName"
							data-parsley-required="true" data-parsley-trigger="change"
							placeholder="Movie Name" />
					</div>
				</div>
				<div class="form-group">
					<label>Movie Description</label>
					<div>
						<form:textarea path="description" rows="3" cols="20" class="form-control" name="movieDescription"
							data-parsley-required="true" data-parsley-trigger="change" placeholder="Movie Description" />
					</div>
				</div>

				<div class="form-group">
					<label>Ticket Price</label>
					<div>
						<form:input path="details.price" class="form-control" name="ticketPrice"
							data-parsley-type="digits" data-rangelength="[11,20]"
							data-parsley-required="true" data-parsley-trigger="change" />
					</div>
				</div>
				<div class="form-group">
					<label>Hall Name/Number</label>
					<div>
						<form:input path="details.hall" class="form-control"
							name="firstname" data-parsley-required="true"
							data-parsley-trigger="change" placeholder="First Name" />
					</div>
				</div>
				<div class="form-group">
					<label>Total Seat</label>
					<div>
						<form:input path="details.totalSeats" class="form-control" name="firstname"
							data-parsley-required="true" data-parsley-trigger="change"
							placeholder="Organisation Address" />
					</div>
				</div>
				<%-- 
				<div class="form-group">
					<label>Screening Date</label>
					<div>
						<form:input path="details.screeningDate" class="form-control" name="firstname"
							data-parsley-required="true" data-parsley-trigger="change"
							placeholder="YYYY-MM-DD" />
					</div>
				</div> --%>


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