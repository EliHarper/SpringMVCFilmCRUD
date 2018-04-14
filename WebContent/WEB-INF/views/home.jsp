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
	</form>

	<form action="filmId.do" method="GET">
		<input type="text" name="filmID" value="${filmId}"> 
		<input type="submit" value="Look up film by ID">
	</form>
	
	<form action="addFilm.do" method="GET">
		Title: <input type="text" name="title"> <br> 
		Description: <input type="text" name="description"> <br>
		Release Year: <input type="text" name="releaseYear"> <br>
		Release Year: <input type="text" name="releaseYear"> <br>
		Language: <input type="text" name="language"> <br>
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
		</select>
		Special Features: <input type="text" name="specialFeatures"> <br>
		<input type="submit" value="Add New Film">
	</form>
</body>
</html>