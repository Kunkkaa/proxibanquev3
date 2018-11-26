package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;


/**
 * Classe permettant d'accéder, d'envoyer des informations et de récupérer des informations liées à l'édition d'un client.
 *  * @author Adminl
 *
 */
public class EditorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Méthode permettant d'accéder à editor.jsp.
	 * Récupère l'id du client dans la requête, et renvoie en attribut dans la réponse un objet client obtenu par la fonction read de client service.
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		req.setAttribute("client", client);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/editor.jsp").forward(req, resp);
	}

	/**
	 * Méthode permettant de récupérer les résultats d'un formulaire sur editor.jsp.
	 * Récupère les différents éléments entrés dans le formulaire pour la modification du client. 
	 * Créée une nouvelle instance de client avec les éléments récupérés et l'envoie à la classe ClientService pour modifier les informations dans la base de données. 
	 * Redirige l'utilisateur sur la page d'accueil.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String lastname = req.getParameter("lastname");
		String firstname = req.getParameter("firstname");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		
		Client client = new Client(id, firstname, lastname, email, address);
		
		ClientService.getInstance().update(client);
		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
		
	}
}
