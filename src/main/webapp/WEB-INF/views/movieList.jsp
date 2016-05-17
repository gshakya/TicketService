<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Find Movie</h1>
	<form action="${pageContext.request.contextPath}/movie/findMovie"
		method="get" name="searchMovie">


		<br> Movie Name <input type="text" name="movieName"> <br>Date
		<input type="datetime-local" path="tempdate"
			class="form-control margin-bottom-20" name="searchDate"
			placeholder="Date" /> <input type="submit" value="Find"> <br>
	</form>
	<table padding="6px" bordercolor="black">
		<tr>
			<td>Movie Name</td>
			<td>Movie Description</td>
			<td>Hall</td>
			<td>Screening Date</td>
			<td>Total Seat</td>
			<td>Price</td>
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
				<td>
					<form method="post" name="buyTicket"
						action="${pageContext.request.contextPath}/movie/buyTicket">
						<input type="hidden" value=${movie.movieId } name="movieId" />
						<input value="Buy Ticket" type="submit">
					</form>
				</td>
				<td>
				<a href="${pageContext.request.contextPath}/movie/edit/${movie.movieId }">Edit</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
	<script type="text/javascript">
		function buyTicket(id) {
			$
					.ajax({
						type : "POST",
						contentType : "application/json; charset=utf-8",
						url : "${pageContext.request.contextPath}/movie/buyTicket?movieId="
								+ id,
						success : function(response) {
							console.log("MovieId Sent " + id);
						}
					});
		}
	</script>
</body>
</html>
