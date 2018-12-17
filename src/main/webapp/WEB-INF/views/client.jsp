<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>ProxiBanque SI</title>

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

<body id="page-top">
	<!-- Header -->
	<header class="masthead">
		<div class="container">
			<div class="intro-text"
				style="padding-top: 150px; padding-bottom: 200px;">
				<div class="intro-lead-in">Bienvenue Monsieur
					${client.firstname} ${client.lastname}</div>
				<div class="intro-heading text-uppercase">PROXIBANQUE</div>
			</div>
		</div>
	</header>

	<section class="account-body">
		<div class="header-account">
			<h1 class="page-title">Liste des comptes</h1>
			<div class="transfer-button">
				<a href="transfer.html?id=${id}">
					<button class="button">Faire un virement</button>
				</a>
			</div>
		</div>
		<div class="account-list">
			<div class="left-list">
				<h2>Liste des comptes courant</h2>
				<c:if test="${empty currentAccounts}">
					<h4>Aucun compte associ� � ce client.</h4>
				</c:if>
				<c:if test="${not empty currentAccounts}">
					<table>
						<tr>
							<th>Numero de compte</th>
							<th class="balance">Solde en &#8364</th>
						</tr>
						<c:forEach var="currentAccount" items="${currentAccounts }">
							<tr class="data">
								<c:if test="${currentAccount.card.isElectron}">
									<h2>Votre carte est une Electron</h2>
								</c:if>

								<c:if test="${currentAccount.card.isElectron}">
									<h2>Votre carte est une Premier</h2>
								</c:if>
								<td>${currentAccount.card.number}</td>
								<td class="balance">${currentAccount.balance}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="right-list">
				<h2>Liste des comptes epargne</h2>
				<c:if test="${empty savingAccounts}">
					<h4>Aucun compte associ� � ce client.</h4>
				</c:if>
				<c:if test="${not empty savingAccounts}">
					<table>
						<tr>
							<th>Numero de compte</th>
							<th class="balance">Solde en &#8364</th>
						</tr>
						<c:forEach var="savingAccount" items="${savingAccounts }">
							<tr class="data">
								<td>${savingAccount.number}</td>
								<td class="balance">${savingAccount.balance}</td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>

	</section>

	<!-- Affichage des clients -->
	<section id="clients-display">
		<h1 class="page-title">Voici vos Informations</h1>
		<div class="client-display">
			<div class="client-container">
				<div class="client-contain">
					<p class="name">${client.firstname}${client.lastname}</p>

					<p class="text">${client.birthdate}</p>

					<p class="text">${client.address.field1}</p>

					<p class="text">${client.address.town}</p>

					<p class="text">${client.address.postalCode}</p>

					<p class="text">${client.address.country}</p>

					<div class="button-container">

						<div>
							<a href="transfer.html?id=${client.id}">
								<button class="button">Virement</button>
							</a>
						</div>
						<div>
							<div>
								<a href="card.html?id=${client.id}">
									<button class="button">Changer de Carte</button>
								</a>
							</div>
						</div>
						<div>
							<a href="delete_card.html?id=${client.id}">
								<button class="button">Supprimer la carte</button>
							</a>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<div class="footer-button">
		<a href="index.html">
			<button class="button">Retour � l'accueil</button>
		</a>
	</div>

	<!-- Team -->
	<section class="bg-light" id="team">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">Sexy &amp; Chocolat
						Dream Team</h2>
					<h3 class="section-subheading text-muted">D�couvrez notre
						superbe �quipe !</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/1.jpg" alt="">
						<h4>Omar Boughanem</h4>
						<p class="text-muted">Developpeur</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-facebook-f"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-linkedin-in"></i>
							</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="team-member">
						<img class="mx-auto rounded-circle" src="img/team/2.jpg" alt="">
						<h4>Bixente Olasaguirre</h4>
						<p class="text-muted">Developpeur</p>
						<ul class="list-inline social-buttons">
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-twitter"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-facebook-f"></i>
							</a></li>
							<li class="list-inline-item"><a href="#"> <i
									class="fab fa-linkedin-in"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-8 mx-auto text-center">
					<p class="large text-muted">Notre team est � votre �coute,
						n'h�sitez pas � nous contacter.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<span class="copyright">Copyright &copy; Proxibanque 2018</span>
				</div>
				<div class="col-md-4">
					<ul class="list-inline quicklinks">
						<li class="list-inline-item"><a href="#">Privacy Policy</a></li>
						<li class="list-inline-item"><a href="#">Terms of Use</a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="js/jqBootstrapValidation.js"></script>
	<script src="js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/agency.min.js"></script>

</body>

</html>