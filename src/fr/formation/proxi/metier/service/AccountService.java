package fr.formation.proxi.metier.service;

public class AccountService {
	
private static final AccountService INSTANCE = new AccountService();
	

	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

}
