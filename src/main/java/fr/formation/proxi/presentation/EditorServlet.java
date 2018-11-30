package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant d'acceder � la page d'edition des informations d'un client.
 * * @author Adminl
 *
 */
public class EditorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Methode permettant d'acceder a� editor.jsp. Recupere l'id du client dans
	 * la requete, et renvoie en attribut dans la reponse un objet client obtenu
	 * par la fonction read de client service.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		req.setAttribute("client", client);
		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/editor.jsp")
				.forward(req, resp);
	}

	/**
	 * Methode permettant de recuperer les resultats d'un formulaire sur
	 * editor.jsp. Recupere les differents elements entres dans le formulaire
	 * pour la modification du client. Cree une nouvelle instance de client avec
	 * les elements recuperes et l'envoie a� la classe ClientService pour
	 * modifier les informations dans la base de donnees. Redirige l'utilisateur
	 * sur la page d'accueil.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		// Pour pouvoir mettre à jour les informations du client, on récupère
		// d'abord toutes les informations connues depuis la base de données.
		Client client = ClientService.getInstance().read(id);
		// On met ensuite à jour chaque nouvelle valeur saisies par
		// l'utilisateur dans l'objet Java en mémoire.
		client.setLastname(lastname);
		client.setFirstname(firstname);
		client.setAddress(address);
		client.setEmail(email);
		// Et on termine par appeler le service pour aller mettre à jour tout
		// l'objet client avec ses informations (et ses comptes !) en base de
		// données.
		ClientService.getInstance().update(client);

		this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/edit_OK.jsp")
				.forward(req, resp);

	}
}
