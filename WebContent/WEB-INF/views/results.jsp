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
		<c:when test="${not empty films}">
			<c:forEach var="f" items="${films}">
				<h1>Title: ${f.title}</h1>
				<h5>Film ID: ${f.id}</h5><br>
				<h2>Film Information:</h2>
				<h5>
					Release Year: ${f.releaseYear}<br>Rating: ${f.rating}<br>Length:
					${f.length}<br>Language: ${f.language}
				</h5>
				<h2>Rental Information:</h2>
				<h5>
					Rental Duration: ${f.rentalDuration}<br> Rental Rate:
					${f.rentalRate}<br> Replacement Cost: ${f.replacementCost}<br>
					Special Features: ${f.specialFeatures}
				</h5>
				<h2>Description:</h2>
				<h5>${f.description}</h5>
				<h2>Cast:</h2>
				<ul>
					<h5>
						<c:forEach var="a" items="${f.cast}">
							<li>${a}</li>
						</c:forEach>
				</ul>
				</h5>
				
	</form>
				
			</c:forEach>
		</c:when>

		<c:when test="${not empty film}">
			<h1>Title: ${film.title}</h1>
			<h4>Film ID: ${film.id}</h4>
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
			<h2>Cast:</h2>
			<ul>
				<h5>
					<c:forEach var="a" items="${film.cast}">
						<li>${a}</li>
					</c:forEach>
			</ul>
			</h5>
	</form>
			
		</c:when>

		<c:otherwise>
			<p>No film found</p>
		</c:otherwise>
	</c:choose>
</body>
</html>