<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editeur client</title>
	</head>
	<body>
		<h1>Page Edition Client </h1>
		
		<form method="post" action="modify.html?id=${client.id}">
			<label for="lastname">Nouveau Nom</label>
			<input type="text" id="lastname" value="${client.lastname}" name="lastname">
			
			<label for="firstname">Nouveau Prénom</label>
			<input type="text" id="firstname" value="${client.firstname}" name="firstname">
			
			<label for="email">Nouveau Mél</label>
			<input type="email" id="email" value="${client.email}" name="email">
			
			<label for="address">Nouvelle Adresse</label>
			<input type="text" id="address" value="${client.address}" name="address">
			
			<button>Valider</button>
			<button type="reset">Réinitialiser</button>
		</form>
	</body>
</html>