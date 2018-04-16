<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Film</title>
</head>
<body>

	<h2>Delete Film</h2>
	
	<br><br><br>
	<form:form action="deleteResult.do" method="POST" modelAttribute="film">
	Please enter the ID of the film you would like to delete: <input type="text" name="id">
	<input type="submit" value="Delete"/>
		</form:form>
		
	<br><br><br>
	
	<form:form action="home.do">
	<input type="submit" value="Return to Home">
	</form:form>

</body>
</html>