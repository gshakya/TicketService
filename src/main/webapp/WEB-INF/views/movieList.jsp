<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Movie</title>
</head>
<body>

	<sec:authorize
		access="! hasAnyRole('ROLE_MOVIEMANAGER','ROLE_REGISTERVIEWER')">
		<a href="${pageContext.request.contextPath}/login"> Login </a>
	</sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<a href="${pageContext.request.contextPath}/admin"> Admin
			Dashboard </a>
	</sec:authorize>
	<sec:authorize
		access="hasAnyRole('ROLE_MOVIEMANAGER','ROLE_REGISTERVIEWER')">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" method="post">
			<input class="btn btn-primary" type="submit" value="Logout" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>

		<a href="register">Register</a>

	</sec:authorize>




	<h1>Find Movie</h1>
	<form action="${pageContext.request.contextPath}/movie/findMovie"
		method="get" name="searchMovie">


		<br> Movie Name <input type="text" name="movieName"> <br>Date
		<input type="datetime-local" path="tempdate"
			class="form-control margin-bottom-20" name="searchDate"
			placeholder="Date" /> <input type="submit" value="Find"> <br>
	</form>

	<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
		<a href="${pageContext.request.contextPath}/movie/new">Add Movie</a>

	</sec:authorize>
	<table cellpadding="6px" bordercolor="black">
		<tr>
			<td>Movie Name</td>
			<td>Movie Description</td>
			<td>Hall</td>
			<td>Screening Date</td>
			<td>Total Seat</td>
			<td>Price</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>

		<c:forEach items="${movies}" var="movie">

			<tr>
				<td>${movie.movieName}</td>
				<td>${movie.description}</td>
				<td>${movie.details.hall}</td>
				<td>${movie.details.screeningDate}</td>
				<td>${movie.details.totalSeats}</td>
				<td>${movie.details.price}</td>
				<td><sec:authorize access="hasAnyRole('ROLE_REGISTERVIEWER')">
						<form method="post" name="buyTicket"
							action="${pageContext.request.contextPath}/movie/buyTicket">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden"
								value=${movie.movieId } name="movieId" /> <input
								value="Buy Ticket" type="submit" />
						</form>
					</sec:authorize></td>
				<sec:authorize access="hasAnyRole('ROLE_MOVIEMANAGER')">
					<td><a
						href="${pageContext.request.contextPath}/movie/edit/${movie.movieId }">Edit</a>
					</td>
					<td><a
						href="${pageContext.request.contextPath}/movie/delete/${movie.movieId }">Delete</a>
					</td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
