<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Outil de gestion des comptes</title>
</head>
<body>
	<h1>Liste des comptes</h1>
	<ul>
		<c:forEach var="currentAccount" items="${currentAccounts }">
			<li>${currentAccount.number}</li>
		</c:forEach>
	</ul>
	<ul>
		<c:forEach var="savingAccount" items="${savingAccounts }">
			<li>${savingAccount.number}</li>
		</c:forEach>
	</ul>

	<div>
		<a href="transfer.html?id=${id}">
			<button>Virement</button>
		</a>
	</div>
	<div>
		<a href="index.html">
			<button>Accueil</button>
		</a>
	</div>
</body>
</html>