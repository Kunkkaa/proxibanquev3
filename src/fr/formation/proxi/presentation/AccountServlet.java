package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant d'acceder, d'envoyer des informations et de gerer le listing des comptes d'un client.
 *  * @author Adminl
 *
 */
public class AccountServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	
	/**
	 * Methode permettant d'acceder a  account.jsp. 
	 * Recupere l'id du client dans la requete, et renvoie en attribut une liste de comptes courant et une liste de comptes epargne, toutes deux liees au-dit client. 
	 * Renvoie en attribut l'id client.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Account> currentAccounts= AccountService.getInstance().getAllCurrentAccounts(id);
		List<Account> savingAccounts= AccountService.getInstance().getAllSavingAccounts(id);
		Client client = ClientService.getInstance().read(id);
		req.setAttribute("currentAccounts",currentAccounts);
		req.setAttribute("savingAccounts",savingAccounts);
		req.setAttribute("id",id);
		req.setAttribute("client",client);
		
		req.getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp").forward(req, resp);
		
	}
}
