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
 * Classe permettant d'accéder transfer.jsp et de gérer les transferts
 * d'argent entre les comptes d'un client.
 * 
 * @author Adminl
 *
 */

public class TransferServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accS = AccountService.getInstance();

	/**
	 * Méthode permettant d'accéder à la page de transfer. Récupère l'id de
	 * client de la requête pour agir sur ses comptes spécifiquement. Renvoie en
	 * attribut une liste des comptes dudit client . Si le client possède 1 compte
	 * ou moins, l'utilisateur est transféré sur une page d'erreur.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		Client client = ClientService.getInstance().read(id);
		List<Account> accounts = this.accS.getAll(id);
		if (accounts.size() <= 1) {
			req.setAttribute("client", client);
			req.getServletContext().getRequestDispatcher("/WEB-INF/views/error_transfer.jsp").forward(req, resp);
		} else {
			req.setAttribute("accounts", accounts);
			req.setAttribute("client", client);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
		}
	}

	/**
	 * Méthode permettant de traiter un formulaire rempli sur transfer.jsp. Renvoie
	 * les informations des comptes utilisés pour le transfert et le montant du
	 * transfert choisit par l'utilisateur. Si le transfer échoue dans la méthode
	 * transfer() de ClientService, renvoie sur une page d'erreur.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer compteCredite = Integer.parseInt(req.getParameter("compteACrediter"));
		Integer compteDebite = Integer.parseInt(req.getParameter("compteADebiter"));
		Float val = Float.parseFloat(req.getParameter("value"));
		Account CompteACrediter = this.accS.getDao().read(compteCredite);
		Account CompteADebiter = this.accS.getDao().read(compteDebite);

		Boolean transferOK = ClientService.getInstance().transfer(val, CompteADebiter, CompteACrediter);

		if (!transferOK) {
			req.setAttribute("transferRate", transferOK);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
		} else {
			resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
		}
	}
}
