<title>Recherche Client</title>

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
	<h1 class="page-title">Type de Card</h1>
	<div class="form-cont">
		<form method="post">
			<%-- 		action="client.html?id=${client.id} --%>

			<div class="form-group">
				<label for="type">Type :</label> 
				<select id="type" name="type">
					<option  value="MasterCard" > MasterCard </option>
					<option value="ElectronCard"> ElectronCard </option>
				</select>
				</div>
	
	<div class="buttons">
		<button class="button">Valider</button>
		<button class="button">Retour à l'accueil</button>

	</div>
	</form>
	</div>
</body>
</html>