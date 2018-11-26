<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Outil de virement</title>
	</head>
	<body>
		<select>
			<option label ="---" value =" "/>
			<c:forEach var="account" items="${accounts}">
				<option label="${account.number}" value="${account.id}"/>
			</c:forEach>
		</select>
		<label for ="value"> Montant du virement.</label>
		<input type="number" name ="value" id="value">
	</body>
</html>