package fr.formation.proxi.presentation.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.service.AccountService;
import fr.formation.proxi.metier.service.ChequeStatus;

@Path("/check")
public class ChequeBookWebService {
	
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	
	public ChequeStatus status(Account account) {
		return AccountService.getInstance().statusCheque(account.getId());	
	}
	
	
}