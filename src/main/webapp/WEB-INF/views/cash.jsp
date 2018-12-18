<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Transfert effectue</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<section class="head"></section>
	<h1 class="page-title">Vous souhaitez effectuer un Retrait de
		liquide</h1>


	<c:if test="${not empty withdrawRate}">
		<h1 class="page-title">Erreur : Le compte à debiter aura un solde
			negatif avec le montant renseigné</h1>
	</c:if>

	<div class="centered-input">
		<div>
			<label for="value" class="text"> Montant du retrait : </label> <input
				type="number" step=0.01 name="value" id="value"
				style="margin-left: 0.5em;">
			<button style="margin-left: 2em;" class="button">Confirmer</button>
		</div>
	</div>



	<div class="footer-button">
		<a href="/client.html?id=${client.id}">
			<button class="button">Retour à l'accueil</button>
		</a>
	</div>





	<div class="transfer-button">
		<a href="/client.html?id=${client.id}">
			<button class="button">Retour à l'accueil</button>
		</a>
	</div>


</body>
</html>