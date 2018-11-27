package fr.formation.proxi.presentation;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant d'acceder a l'application par la page d'accueil index.html.
 * @author Adminl
 *
 */
public class IndexServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(IndexServlet.class.getName());

	/**
	 * Methode permettant d'acceder a  index.jsp.
	 * Recupere et renvoie en attribut une liste des clients issus de ClientService. 
	 * Cette liste sera affichee dans index.jsp. 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Client> clients = ClientService.getInstance().getAll();
		req.setAttribute("clients", clients);
		logger.info("Liste des clients chargée");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
	}

}

