<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Results</title>
</head>
<body>
	<h2>Search for a Film</h2>
	<form action="filmKeyword.do" method="GET">
		<input type="text" name="filmKeyword" value="${filmKeyword}">
		<input type="submit" value="Look up film by Keyword">

		<c:choose>
			<c:when test="${film != null}">
				<c:forEach var="films" items="${film}">
					<h1>Title: ${film.title}</h1>
					<h3>Film Information: ${film.releaseYear} | ${film.rating}
						|${film.length} | ${film.language}</h3>
					<h4>Rental Information:</h4>
					<h3>Rental Duration: ${film.rentalDuration}</h3>
					<h3>Rental Rate: ${film.rentalRate}</h3>
					<h3>Replacement Cost: ${film.replacementCost}</h3>
					<h4>Special Features: ${film.specialFeatures}</h4>
					<h4>Description:</h4>
					<p>${film.description}</p>
				</c:forEach>
			</c:when>
		</c:choose>
	</form>

	<form action="filmId.do" method="GET">
		<input type="text" name="filmKeyword" value="${filmId}"> <input
			type="submit" value="Look up film by ID">

		<c:choose>
			<c:when test="${film != null}">
				<c:forEach var="films" items="${film}">
					<h1>Title: ${film.title}</h1>
					<h3>Film Information: ${film.releaseYear} | ${film.rating}
						|${film.length} | ${film.language}</h3>
					<h4>Rental Information:</h4>
					<h3>Rental Duration: ${film.rentalDuration}</h3>
					<h3>Rental Rate: ${film.rentalRate}</h3>
					<h3>Replacement Cost: ${film.replacementCost}</h3>
					<h4>Special Features: ${film.specialFeatures}</h4>
					<h4>Description:</h4>
					<p>${film.description}</p>
				</c:forEach>
			</c:when>
		</c:choose>
	</form>
	<form action="addFilm.do" method="GET">
		Title: <input type="text" name="title"> <br> Description:
		<input type="text" name="description"> <br> 
		<select id="rating" name="rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG-13">PG-13</option>
			<option value="R">R</option>
			<option value="NC-17">NC-17</option>
		</select>
	</form>
</body>
</html>