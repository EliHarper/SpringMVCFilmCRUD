<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film Database</title>
</head>
<body>
	<h2>Search for a Film:</h2>
	<form action="filmKeyword.do" method="GET">
		<input type="text" name="filmKeyword" value="${filmKeyword}">
		<input type="submit" value="Look up film by Keyword">

		<c:choose>
			<c:when test="${film != null}">
				<c:forEach var="films" items="${film}">
					<h1>Title: ${film.title}</h1>
					<h3>Film Information: ${film.releaseYear} | ${film.rating}
						| ${film.length} | ${film.language}</h3>
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
		<input type="text" name="filmID" value="${filmID}"> <input
			type="submit" value="Look up film by ID">

		<c:choose>
			<c:when test="${film != null}">
				<c:forEach var="films" items="${film}">
					<h1>Title: ${film.title}</h1>
					<h4>Film Information: ${film.releaseYear} | ${film.rating}
						|${film.length} | ${film.language}</h4>
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
	</form><br><br><br>
	<h2>Add a Film:</h2>
	
	<form action="addFilm.do" method="POST">
		Title: <input type="text" name="title"> <br> 
		Description: <input type="text" name="description"> <br>
		Release Year: <input type="text" name="releaseYear"> <br>
		Language: <select id="language" name="language">
			<option value="English">English</option>
			<option value="Italian">Italian</option>
			<option value="Japanese">Japanese</option>
			<option value="Mandarin">Mandarin</option>
			<option value="French">French</option>
			<option value="German">German</option>
		</select><br>
		Rental Duration: <input type="text" name="rentalDuration"> <br>
		Rental Rate: <input type="text" name="rentalRate"> <br>
		Length: <input type="text" name="length"> <br>
		Replacement Cost: <input type="text" name="replacementCost"> <br>
		Rating: <select id="rating" name="rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG-13">PG-13</option>
			<option value="R">R</option>
			<option value="NC-17">NC-17</option>
		</select><br>
		Special Features: <select id="specialFeatures" name="specialFeatures">
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind the Scenes">Behind the Scenes</option>
		</select><br>
		<input type="submit" value="Add New Film">
	</form>
	<br><br><br>
	<h2>Update a Film:</h2>
	<form action="updateFilm.do" method="GET">
		Please enter the ID of the film you would like to update: <input type=text" name="id"> <br>
		<input type="submit" value="Update Film">
	</form>
</body>
</html>