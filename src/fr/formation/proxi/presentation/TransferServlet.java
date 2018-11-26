package fr.formation.proxi.presentation;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ClientService;

public class TransferServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccountService accS = AccountService.getInstance();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		List<Account> accounts = this.accS.getAll(id);
		if (accounts.size() <= 1) {
			req.getServletContext().getRequestDispatcher("/WEB-INF/views/error_transfer.jsp").forward(req, resp);
		} else {
		req.setAttribute("accounts", accounts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/transfer.jsp").forward(req, resp);
		}
	}
	
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
