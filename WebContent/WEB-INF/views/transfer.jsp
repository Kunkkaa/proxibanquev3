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
	<c:if test="${not empty transferRate}">
		<h1>Erreur. Le compte a debiter aura un solde negatif avec le
			montant renseigné</h1>
		<a href="index.html">
			<button>J'approuve mon idiotie et m'en vais</button>
		</a>
	</c:if>
	<section></section>

	<c:if test="${fn:length(accounts) > 1}">

		<form method="post" action="">
			<div>
				<fieldset>
					<legend> Compte à débiter </legend>
					<c:forEach var="account" items="${accounts}">
						<div>
							<input id="compteADebiter" type="radio" name="compteADebiter"
								value="${account.id}"> <label for="compteADebiter">Compte
								: n°${account.number} ------------ Solde :
								${account.balance}&#8364</label>
						</div>
					</c:forEach>
				</fieldset>
			</div>
			<div>
				<fieldset>
					<legend> Compte à créditer </legend>
					<c:forEach var="account" items="${accounts}">
						<div>
							<input id="compteACrediter" type="radio" name="compteACrediter"
								value="${account.id}"> <label for="compteACrediter">Compte
								: n°${account.number} ------------ Solde :
								${account.balance}&#8364</label>
						</div>
					</c:forEach>
				</fieldset>
			</div>
			<label for="value"> Montant du virement.</label> <input type="number"
				name="value" id="value">
			<button>Confirmer</button>
		</form>
	</c:if>

</body>
</html>