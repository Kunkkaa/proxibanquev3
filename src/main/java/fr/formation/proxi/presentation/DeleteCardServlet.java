package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.BankCardService;
import fr.formation.proxi.metier.service.ClientService;

public class DeleteCardServlet extends HttpServlet {
	
	private static final Logger LOGGER = Logger.getLogger(DeleteCardServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		//CurrentAccount account = AccountService.getInstance().read(id);
//		if (account.getCard() != null) {
//			Integer cardId = account.getCard().getId(); 
//		account.setCard(null);
//			ClientService.getInstance().update(null);
//			BankCardService.getInstance().delete(cardId);
//		} else {
//			LOGGER.warn("Trying to delete a card for a client that doesn't have one. Operation canceled.");
//		}
//		resp.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
	}
}
