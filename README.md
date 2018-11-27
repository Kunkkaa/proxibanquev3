ProxiBanqueSIv2_Quentin_Axel
Bienvenue dans ProxiBanqueSI. Ce document a pour objectif de vous aider à utiliser l'application le plus sereinement possible.

Table des Matières : 
	1 - Prérequis
	2 - Execution
	3 - Utilisation
	4 - Fonctionalités
	5 - Ressources complémentaires

	ATTENTION : Ce document contient des informations importantes pour le fonctionnement de ProxiBanqueSI. Veuillez le lire attentivement
	pour vous assurer la meilleure expérience possible. Les développeurs ne sauraient être tenus responsables d'une mauvaise utilisation
	de l'application découlant d'une mauvaise lecture de ce document. 
	
1. Prérequis. 
Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien installé sur votre appareil. Si ce n'est pas le cas, vous 
pouvez le télécharger à cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Pensez bien à vérifier le niveau de votre Système d'exploitation avant de télécharger. Vous pouvez vérifier votre système d'exploitation 
sous Windows dans Panneau de Configuration -> Système et Sécurité -> Système. Votre niveau de Système correspond à l'indication 
32bits ou 64bits, et vous devez télécharger la distribution de Java correpondante.
Vous devez également avoir un outil pour décompresser les fichiers installé sur votre ordinateur. Si vous n'en avez pas, 
vous pouvez en télécharger un gratuitement ici : https://www.7-zip.org/ 
De même téléchargez bien la version correspond à votre niveau de Système. 

2. Exécution.
Pour Exécuter ProxiBanqueSI il vous suffit de décompresser l'archive qui est en .zip, de rentrer dans le fichier décompressé,
et de lancer run.bat.

3. Utilisation. 
ProxiBanqueSI est une application permettant de simuler la gestion d'un portefeuille client d'un conseiller bancaire. L'application 
se lance avec toutes les données nécessaires au fonctionnement des simulations proposées par l'application. Aucun fichier extérieur 
n'est requis.
Dans l'application, la simulation se compose d'une agence, qui possède un manager et un conseiller. 
Ce conseiller possède 4 clients aux identités suivantes (prénom, nom dans cet ordre ici): 
 - Martin Dupont
 - Germaine Dupont
 - Red Ketchum
 - Cidolfus Orlandeau
ATTENTION : Il vous faut ces identités pour utiliser les différentes fonctionalités de l'application. 
ATTENTION : l'application est sensible à la casse. Quand vous entrez une données, assurez-vous bien qu'elle corresponde parfaitement.

4. Fonctionalités.
Pour la gestion du portefeuille client, ProxiBanqueSI vous permet ces fonctionalités : 
 - Créer un nouveau client dans le portefeuille. La création s'accompagne de la création d'un ou plusieurs compte(s) bancaire(s) 
et de la création d'une carte bleue. Il est possible d'utiliser les autres fonctionalités sur un client ainsi créé 
s'il répond aux prérequis de la fonctionalité.
 - Consulter la fiche client d'un client : permet d'afficher toutes les informations liées à un client. Affiche également 
les informations des comptes du client. 
 - Supprimer client : Supprimer un client de la base de données.
 - Modifier client : Permet de modifier une information de la liste client. Ne permet pas de modifier les informations de compte.
 - Effectuer un virement : permet d'effectuer un virement entre les comptes Courant et Epargne d'un client.
 - Simuler un Crédit de consommation : Permet de lancer une simulation de crédit de consommation pour un client.
 - Simuler Crédit Immobilier : Permet de lancer une simulation de crédit immobilier pour un client. 
 
 ATTENTION : ProxiBanqueSI traite la plupart des erreurs que l'utilisateur pourrait être amené à rencontrer. 
 A la connaissance des développeurs un cas commun n'est pas pris en compte : 
   - Si des informations sont demandées pour un client qui n'appartient pas au portefeuille de clients.
      -> Ne renvoie rien. L'application continue de tourner dans le vide.
 Il est possible que d'autres erreurs existent.

5. Ressources complémentaires. 
L'application ProxiBanqueSI est livrée avec deux diagrammes UML représentant : 
	- Les cas d'utilisation.
	- Le Diagramme de Classe.
Ces deux diagrammes sont assez petits, mais il est possible de zoomer dessus pour avoir un accès plus clair aux informations.

Il est également possible de consulter le code de ProxiBanqueSI à l'adresse suivante : 
https://github.com/LeGreed/proxibanquesiv1_Bixente_Axel


Merci d'avoir lu ce document. Nous vous souhaitons une bonne expérience avec ProxiBanqueSI. 
