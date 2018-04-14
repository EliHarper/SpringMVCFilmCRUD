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
			<c:forEach var="film" items="${films}">
				<h1>Title: ${film.title}</h1>
				<h4>ID: ${film.id}</h4>
				<h2>Film Information:</h2>
				<h5>
					Release Year: ${film.releaseYear}<br>Rating: ${film.rating}<br>Length:
					${film.length}<br>Language: ${film.language}
				</h5>
				<h2>Rental Information:</h2>
				<h5>
					Rental Duration: ${film.rentalDuration}<br> Rental Rate:
					${film.rentalRate}<br> Replacement Cost:
					${film.replacementCost}<br> Special Features:
					${film.specialFeatures}
				</h5>
				<h2>Description:</h2>
				<h5>${film.description}</h5>
				<%-- <c:forEach var="a" items="${film.actor}">
				${a.firstName} ${a.lastName}
			</c:forEach> --%>
				<form action="editFilm.do" method="GET">
					<input type="submit" value="Edit Film">
				</form>
				<form action="deleteFilm.do" method="GET">
					<input type="submit" value="Delete Film">
				</form>
			</c:forEach>



		</c:when>
		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>