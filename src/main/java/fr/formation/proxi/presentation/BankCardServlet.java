package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.BankCardService;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant d'acceder à la page d'edition des informations d'un client.
 * * @author Adminl
 *
 */
public class BankCardServlet extends HttpServlet {

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
		
		
	
		// String type = req.getParameter("type");
		
		
	
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/typeCard.jsp")
			.forward(req, resp);

			
		}
		


	/**
	 * Methode permettant de recuperer les resultats d'un formulaire sur
	 * editor.jsp. Recupere les differents elements entres dans le formulaire
	 * pour la modification du client. Cree une nouvelle instance de client avec
	 * les elements recuperes et l'envoie a la classe ClientService pour
	 * modifier les informations dans la base de donnees. Redirige l'utilisateur
	 * sur la page d'accueil.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		Integer idAccount = Integer.parseInt(req.getParameter("accountId"));
		Integer idClient = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("idclient", idClient);
		
		
		boolean a = AccountService.getInstance().newCard(idAccount,req.getParameter("type"));
		
		if(a) {
			
			resp.sendRedirect(this.getServletContext().getContextPath()+"/search.html?id="+idClient);

			
		} else {
			
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/error_card.jsp")
			.forward(req, resp);
			
		}
		
}
}
