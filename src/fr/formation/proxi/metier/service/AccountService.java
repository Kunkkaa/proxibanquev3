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

	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.dao.readAllAccountsForOneClient(idClient);

		return accounts;

	}

	public AccountDao getDao() {
		return this.dao;
	}

	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.dao.readAllAccountsForOneClient(idClient);

		for (Account account : accounts) {
			if (account.isSavings()) {
				SavingAccounts.add(account);
			}
		}

		return SavingAccounts;

	}

	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.dao.readAllAccountsForOneClient(idClient);

		for (Account account : accounts) {
			if (!account.isSavings()) {
				CurrentAccounts.add(account);
			}
		}

		return CurrentAccounts;

	}

}
