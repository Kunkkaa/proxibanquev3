package fr.formation.proxi.metier.service;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

public class ClientService {

	private static final ClientService INSTANCE = new ClientService();

	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	private final ClientDao daoClient;
	private final AccountDao daoAccount;

	public ClientService() {
		this.daoClient = new ClientDao();
		this.daoAccount = new AccountDao();
	}

	public List<Client> getAll() {
		return this.daoClient.readAll();
	}

	public void transfer(Float value, Account compteDebite, Account compteCredite) {

		Account compteDebiteActualise = new Account(compteDebite.getId(), compteDebite.getNumber(),
				(compteDebite.getBalance() - value), compteDebite.isSavings());
		Account compteCrediteActualise = new Account(compteDebite.getId(), compteDebite.getNumber(),
				(compteDebite.getBalance() + value), compteDebite.isSavings());
		
		this.daoAccount.update(compteDebiteActualise);
		this.daoAccount.update(compteCrediteActualise);
		
	

	}

}
