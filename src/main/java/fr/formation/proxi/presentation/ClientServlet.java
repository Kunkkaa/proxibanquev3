package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.BankCardService;
import fr.formation.proxi.metier.service.ClientService;

public class ClientServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Account> currentAccounts= AccountService.getInstance().getAllCurrentAccounts(id);
		
		List<Account> savingAccounts= AccountService.getInstance().getAllSavingAccounts(id);
		
		Client client = ClientService.getInstance().read(id);
		
		//BankCard bankcard = BankCardService.getInstance().read(id);
		
		req.setAttribute("currentAccounts",currentAccounts);
		req.setAttribute("savingAccounts",savingAccounts);
		req.setAttribute("id",id);
		req.setAttribute("client",client);
		
		req.getServletContext().getRequestDispatcher("/WEB-INF/views/client.jsp").forward(req, resp);
	}

}
