package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant de gerer l'affichage de l'ecran d'accueil en chargeant la
 * liste des clients de l'application.
 * 
 * @author Adminl
 *
 */
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexServlet.class.getName());

	/**
	 * Methode permettant d'acceder a� index.jsp. Recupere et renvoie en
	 * attribut une liste des clients issus de ClientService. Cette liste sera
	 * affichee dans index.jsp.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Lorsque le LoginModule de JAAS effectue le login avec succès,
		// il rempli les différents objets java.security.Principal avec les
		// informations de connexion : nom d'utilisateur et rôle pour nous ici.
		// Il y a donc un Principal pour notre nom de conseiller, et un autre
		// que nous n'utilisons pas pour le nom du rôle.
		// Etant donné que JAAS a rempli le UserPrincipal avec notre nom de
		// conseiller, il nous suffit de le récupérer.
		
		// Vérifier si le conseiller est dans la session utilisateur.
		if (req.getSession().getAttribute("advisor") == null) {
			// L'attribut n'est pas encore en session.
			// Récupérer le nom du conseiller.
			String advisor = req.getUserPrincipal().getName();
			// Ajout de l'attribut dans la session de l'utilisateur pour accéder
			// à cette information depuis les pages JSP.
			req.getSession().setAttribute("advisor", advisor);
		}
		// TODO:
		// - Récupérer une instance du service pour le conseiller
		// - Récupérer le nom du UserPrincipal connecté
		// - Appeler le service pour récupérer l'identifiant du conseiller
		// - Appeler le service pour récupérer la liste des clients à partir de l'identifiant obtenu
		
		List<Client> clients = new ArrayList<>();// ancienne valeur : ClientService.getInstance().getAll();
		req.setAttribute("clients", clients);
		logger.info("Liste des clients chargée");

		// On continue avec la page JSP.
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(req,
				resp);
	}

}
