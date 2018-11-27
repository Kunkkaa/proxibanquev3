package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ClientService;

/**
 * Classe permettant de gerer les transferts
 * d'argent entre les comptes d'un même client. permet de faire un virement si le client possède au moins 2 comptes.
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
	 * Methode permettant d'acceder a  la page de transfer. Recupere l'id dy
	 * client de la requete pour agir sur ses comptes specifiquement. Renvoie en
	 * attribut une liste des comptes dudit client. Si le client possede 1 compte
	 * ou moins, l'utilisateur est transfere sur une page d'erreur.
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
	 * Methode permettant de traiter un formulaire rempli sur transfer.jsp. Renvoie
	 * les informations des comptes utilises pour le transfert ainsi que le montant du
	 * transfert choisi par l'utilisateur. Si le transfert echoue dans la methode
	 * transfer() de ClientService, affiche un message d'erreur a l'utilisateur.
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
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer_OK.jsp").forward(req, resp);
		}
	}
}
