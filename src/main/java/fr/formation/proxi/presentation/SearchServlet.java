package fr.formation.proxi.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.service.ClientService;

public class SearchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		this.getServletContext()
		.getRequestDispatcher("/WEB-INF/views/search.jsp")
		.forward(req, resp);
		
		
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mot[] = req.getParameter("name").split(" ");
		String lastname = mot[1];
		String firstname = mot[0];
		System.out.println(firstname + lastname);
		Client client = ClientService.getInstance().check(firstname, lastname);
		if ( client == null ) {
			
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/error.jsp")
			.forward(req, resp);
			
		} else {
			Integer Id = client.getId();
			System.out.println(Id);
			this.getServletContext()
			.getRequestDispatcher("/WEB-INF/views/client.jsp")
			.forward(req, resp);
			
		}
		
		
		
		//for (Client client : clients)
		
		
	}
	
	
}
