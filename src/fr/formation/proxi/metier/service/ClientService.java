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

	public boolean transfer(Float value, Account compteDebite, Account compteCredite) {
		boolean transferOK = true;
		if (compteDebite.getId() == compteCredite.getId()) {
			return transferOK;
		}
		
		else if (compteDebite.getBalance() - value < 0) {
			transferOK = false;
			return transferOK;
			
		} else {

		Account compteCrediteActualise = new Account(compteCredite.getId(), compteCredite.getNumber(),
				(compteCredite.getBalance() + value), compteCredite.isSavings());
		this.daoAccount.update(compteCrediteActualise);
		
		Account compteDebiteActualise = new Account(compteDebite.getId(), compteDebite.getNumber(),
				(compteDebite.getBalance() - value), compteDebite.isSavings());
		this.daoAccount.update(compteDebiteActualise);
	
		return transferOK;
		}
	}
	
	public Client read(Integer id) {
		
		
		return this.daoClient.read(id);
	}

	public void update(Client client) {
		this.daoClient.update(client);
	}

}
