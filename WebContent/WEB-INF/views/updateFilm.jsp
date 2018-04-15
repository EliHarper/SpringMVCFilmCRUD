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
	<form action="results.do" method="GET">
		Film ID: <input type="text" name="newFilmId" value="${film.id}"><br>
		Title: <input type="text" name="newTitle" value="${film.title}"> <br> 
		Description: <input type="text" name="newDescription" value="${film.description}"> <br>
		Release Year: <input type="text" name="newReleaseYear" value="${film.releaseYear}"> <br>
		languageId <input type="text" name="newLanguageId" value="${film.languageId}">
		Rental Duration: <input type="text" name="newRentalDuration" value="${film.rentalDuration}"> <br>
		Rental Rate: <input type="text" name="newRentalRate" value="${film.rentalRate}"> <br>
		Length: <input type="text" name="newLength" value="${film.length}"> <br>
		Replacement Cost: <input type="text" name="newReplacementCost" value="${film.replacementCost}"> <br>
		Rating: <select id="rating" name="newRating" value="${film.rating}">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG-13">PG-13</option>
			<option value="R">R</option>
			<option value="NC-17">NC-17</option>
		</select><br>
	
		<input type="hidden" name="id" value="${film.id}"/>
		<input type="submit" value="Update Film">
		</form>
</body>
</html>