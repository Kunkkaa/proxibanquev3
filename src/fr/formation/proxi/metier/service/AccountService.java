package fr.formation.proxi.metier.service;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.persistance.AccountDao;

public class AccountService {
	
private static final AccountService INSTANCE = new AccountService();
private AccountDao dao = new AccountDao();
	

	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

<<<<<<< HEAD
	public List<Account> getAll(Integer idClient){
		List<Account>  accounts = this.dao.readAllAccountsForOneClient(idClient);
		
		return accounts;
		
	}
=======
	
	
	
	
>>>>>>> 636200fa345d3f4077ecfaf2ee6086c4051197b7
}
