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
	<c:choose>
		<c:when test="${! empty film}">
			<h1>Title: ${film.title}</h1>
			<h3>Film Information: ${film.releaseYear}	<br> ${film.rating}	<br>${film.length}	<br>${film.language}</h3>
			<h4>Rental Information:</h4>
			<h3>Rental Duration: ${film.rentalDuration}</h3>
			<h3>Rental Rate: ${film.rentalRate}</h3>
			<h3>Replacement Cost: ${film.replacementCost}</h3>
			<h4>Special Features: ${film.specialFeatures}</h4>
			<h4>Description:</h4>
			<p>${film.description}</p>
			<input type="submit" value="Edit Film">
			<input type="checkbox" name="delete">
			
		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>