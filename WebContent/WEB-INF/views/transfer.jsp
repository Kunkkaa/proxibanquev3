<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Outil de virement</title>
	</head>
	<body>
		<section></section>
		
		<c:if test="${fn:length(accounts) > 1}">
		
		<form method="post" action="">
			<div>
				<fieldset>
				<legend> Compte à débiter </legend>
					<c:forEach var="account" items="${accounts}">
						<div>
							<input id="compteADebiter" type="radio" name="compteADebiter" value ="${account.number}">
							<label for="compteADebiter">Compte : n°${account.number} ------------ Solde : ${account.balance}&#8364</label>
						</div>
					</c:forEach>
				</fieldset>
			</div>
			<div>
				<fieldset>
				<legend> Compte à créditer </legend>
					<c:forEach var="account" items="${accounts}">
						<div>
							<input id="compteACrediter" type="radio" name="compteACrediter" value ="${account.number}">
							<label for="compteACrediter">Compte : n°${account.number} ------------ Solde : ${account.balance}&#8364</label>
						</div>
					</c:forEach>
				</fieldset>
			</div>
			<label for ="value"> Montant du virement.</label>
			<input type="number" name ="value" id="value">
			<button>Confirmer</button>
		</form>
		</c:if>
		<c:if test="${fn:length(accounts) <= 1}">
			<div> Votre client ne possède qu'un compte. Tu vas pas virer d'un compte vers le même banane</div>
				<a href="index.html">
					<button> j'approuvem on idiotie et m'en vais</button>
				</a>
		</c:if>
	</body>
</html>