package fr.formation.proxi.presentation.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.service.CheckBookService;
import fr.formation.proxi.metier.service.ChequeStatus;

@Path("/check")
public class ChequeBookWebService {
	
	

	@POST
	
	public ChequeStatus status(Account account) {
		
		return CheckBookService.getInstance().statusCheque(account.getId());
		
		
	}
	
	
	
	
}