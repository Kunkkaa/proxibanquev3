ProxiBanqueSIv2_Quentin_Axel
Bienvenue dans ProxiBanqueSI. Ce document a pour objectif de vous aider à utiliser l'application avec la plus grande sérénité.

Table des Matières : 
	1 - Prérequis
	2 - Execution
	3 - Utilisation
	4 - Fonctionalités
	5 - Ressources complémentaires

ATTENTION : Ce document contient des informations importantes pour le fonctionnement de ProxiBanqueSI. Veuillez le lire 	attentivement
pour vous assurer la meilleure expérience possible. Les développeurs ne sauraient être tenus responsables d'une mauvaise 	utilisation
de l'application découlant d'une mauvaise ou absence de lecture de ce document. 
	
1. Prérequis. 
	Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien installé sur votre appareil. Si ce n'est pas le cas, vous 
pouvez le télécharger à cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
Pensez bien à vérifier le niveau de votre Système d'exploitation avant de télécharger. Vous pouvez vérifier votre système d'exploitation 
sous Windows dans Panneau de Configuration -> Système et Sécurité -> Système. Votre niveau de Système correspond à l'indication 
32bits ou 64bits, et vous devez télécharger la distribution de Java correpondante.
	Vous devez également avoir un outil pour décompresser les fichiers installé sur votre ordinateur. Si vous n'en avez pas, 
vous pouvez en télécharger un gratuitement ici : https://www.7-zip.org/ 
De même téléchargez bien la version correspondant à votre niveau de Système. 
Afin d'utiliser l'application de manière optimale, nous vous recommendons d'utiliser Google Chrome. Vous pouvez télécharger Google Chrome ici : https://www.google.com/chrome/.
Encore une fois n'oubliez pas de vérifier le niveau de votre Système.
Pour information, l'application utilise un système de log pour vérifier son bon déroulement. Pour y avoir accès, il suffit de créer un dossier "logs" dans C://Utilisateurs. L'application créera un fichier "proxi2logging.log" et enregistrera les messages dedans.

Afin de pouvoir profiter de l'application , il est nécessaire de télécharger et d'installer Tomcat. Il est téléchargeable à l'adresse suivante : https://tomcat.apache.org/download-80.cgi.
Veuillez choisir l'installation correspondante à votre système d'exploitation dans "Binary Distributions --> Core". Par exemple, pour Windows 7 ou supérieur, veuillez cliquer sur "64-bit Windows.zip".
Une fois l'archive téléchargée, veuillez l'extraire sur votre PC, le dossier de destination n'ayant pas d'importance.
Il est également nécessaire de définir une nouvelle variable d'environnement "JRE_HOME". Pour cela, dans l'explorateur de fichiers, faites clic droit sur "Ce PC" -> Propriétés. Selectionnez "Paramètres système avancés" sur la gauche. Dans la fenêtre ouverte, choisir "variables d'environnement". Sous le tableau "Variables système", Cliquer sur nouvelle : En "Nom de variable" indiquer JRE_HOME et en chemin de variable, il faut récupérer le chemin vers l'installation du jre ( par défaut C:\\Programmes\\java\\jrexxx ).

Pour avoir accès aux données client, veuillez télécharger l'application MySQL à l'adresse suivante : https://dev.mysql.com/downloads/windows/installer/8.0.html. Selectionnez l'installation à 313Mo. Bien vérifier que MySQL Workbench est installé.


2. Exécution.
Afin de deployer l'application ProxiBanque, veuillez coller l'archive proxibanque2_Quentin_Axel.war dans le dossier webapps de votre dossier apache-tomcat-8.5.35. 
Ensuite, allez dans le dossier bin et double cliquez sur le fichier "startup.bat".
Attendre qu'un dossier proxibanquev2 apparaisse. 

Veuillez ensuite lancer MySQL Workbench et créer un nouveau schéma nommé "proxi2".
Ensuite, selectionner "Server" dans le menu supérieur puis "Data import". Selectionner l'option "Import from Self-Contained File et renseigner le chemin vers le fichier str.sql fourni. indiquer "proxi2" dans "Default Target Schema".
Enfin, répéter l'opération précédente avec le script "data.sql" fourni afin d'importer les données proprement dites.

pour lancer l'application, lancer chrome et rentrer l'adresse suivante : http://localhost:8080/proxibanquev2.

Bonne navigation !!!

3. Utilisation. 
ProxiBanqueSI est une application permettant de simuler la gestion d'un portefeuille client d'un conseiller bancaire. 
Afin de ppouvoir lancer l'application vous devez charger une base de données fictives.

Dans l'application, la simulation se compose d'une agence, qui possède un manager et un conseiller. 
Ce conseiller possède 5 clients aux identités distinctes. Chaque client possède un nom, un prénom, un email, une adresse et une liste de comptes bancaires. 
Il est possible d'explorer l'ensemble des fonctionnalités avec les données fournies dans l'application.

Une fois que votre usage de l'application touche à son terme, lancez le fichier "shutdown.bat" dans le même dossier que "startup.bat"(Apache Tomcat/bin).

4. Fonctionalités.
Pour la gestion du portefeuille client, ProxiBanqueSI vous permet ces fonctionalités : 
	-Afficher l'ensemble des clients du conseiller;
	-Modifier les informations des clients; 
	-Afficher les différents comptes que possède un cilent;
	-Effectuer un virement bancaire entre deux comptes d'un client.
 
 ATTENTION : ProxiBanqueSI traite la plupart des erreurs que l'utilisateur pourrait être amené à rencontrer. 
 A la connaissance des développeurs aucune erreur n'est à relever dans cette version de l'application dans le cadre d'une utilisation normale.
 Certaines erreurs non détectées peuvent subsister. 
 Si des erreurs sont détectées, merci de prévenir au plus vite l'équipe de développement. 


5. Ressources complémentaires. 
L'application ProxiBanqueSI est livrée avec deux diagrammes UML représentant : 
	- Les cas d'utilisation;
	- Le Diagramme de Classe;
	- Les screens des maquettes d'écran. 
	- Le Diagramme des bases de données SQL
	- Les scripts sql pour générer la base de données. 


Il est également possible de consulter le code de ProxiBanqueSI V2 à l'adresse suivante : 
https://github.com/Khantain/proxibanquev2


Merci d'avoir lu ce document. Nous vous souhaitons une bonne expérience avec ProxiBanqueSI. 
