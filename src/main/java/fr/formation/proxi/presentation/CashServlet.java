package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ClientService;

public class CashServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AccountService accS = AccountService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		
		Account account = AccountService.getInstance().read(id);
		
		//req.setAttribute("accounts", account);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/cash.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer accountId = Integer.parseInt(req.getParameter("accountId"));
		Float val = Float.parseFloat(req.getParameter("value"));
		Integer clientId = Integer.parseInt(req.getParameter("id"));
	
		Boolean withdrawOK = ClientService.getInstance().withdrawCash(val, accountId);
		req.setAttribute("clientId", clientId);

		if (!withdrawOK) {
			req.setAttribute("withdrawRate", withdrawOK);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/cash.jsp").forward(req, resp);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/cash_OK.jsp").forward(req, resp);
		}
	}

}
