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
	<h2>Update Film:</h2>
	<form action="updateFilm.do" method="POST">
		Title: <input type="text" name="title" value="${film.title}"> <br> 
		Description: <input type="text" name="description" value="${film.description}"> <br>
		Release Year: <input type="text" name="releaseYear" value="${film.releaseYear}"> <br>
		Language: <select id="language" name="language" value="${film.language}">
			<option value="English">English</option>
			<option value="Italian">Italian</option>
			<option value="Japanese">Japanese</option>
			<option value="Mandarin">Mandarin</option>
			<option value="French">French</option>
			<option value="German">German</option>
		</select><br>
		Rental Duration: <input type="text" name="rentalDuration" value="${film.rentalDuration}"> <br>
		Rental Rate: <input type="text" name="rentalRate" value="${film.rentalRate}"> <br>
		Length: <input type="text" name="length" value="${film.length}"> <br>
		Replacement Cost: <input type="text" name="replacementCost" value="${film.replacementCost}"> <br>
		Rating: <select id="rating" name="rating" value="${film.rating}">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG-13">PG-13</option>
			<option value="R">R</option>
			<option value="NC-17">NC-17</option>
		</select><br>
		Special Features: <select id="specialFeatures" name="specialFeatures" value="${film.specialFeatures}">
			<option value="Trailers">Trailers</option>
			<option value="Commentaries">Commentaries</option>
			<option value="Deleted Scenes">Deleted Scenes</option>
			<option value="Behind the Scenes">Behind the Scenes</option>
		</select><br>
	</form>
		<form action="results.do" method="POST">
					<input type="submit" value="Update Film">
					<input type="hidden" value="${film.id}" name="fid">
		</form>
</body>
</html>