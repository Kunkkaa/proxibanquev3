package fr.formation.proxi.metier.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.SavingsAccount;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.CardDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Clsse regroupant les traitements � effectuer sur les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	private AccountDao accountDao;
	private ClientDao clientDao;
	private CardDao cardDao;

	public AccountService() {
		this.accountDao = AccountDao.getInstance();
		this.clientDao = ClientDao.getInstance();
		this.cardDao = CardDao.getInstance();

	}

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

	/**
	 * Recup�re la liste de tous les comptes associ�s � un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes.
	 * @return La liste des comptes du client.
	 */
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.read(idClient).getAccounts();

		return accounts;

	}

	/**
	 * Recup�re la liste des comptes �pargne d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes �pargne.
	 * @return La liste des comptes �pargne du client.
	 */
	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingAccounts.add(account);
			}
		}
		return SavingAccounts;
	}

	/**
	 * Recup�re la liste des comptes courant d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes courant.
	 * @return La liste des comptes courant du client.
	 */
	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccounts.add(account);
			}
		}
		return CurrentAccounts;
	}

	public boolean newCard(Integer accountId, String type) {
		boolean resultOk = true;
		CurrentAccount account = (CurrentAccount) this.accountDao.read(accountId);

		if (account.getCard() != null) {
			if (account.getCard().getExpirationDate().isBefore(LocalDate.now())) {
				
				
				
				
				Integer cardId = account.getCard().getId();
				// Retirer le lien entre l'ancienne carte et le compte.
				account.setCard(null);
				// Mettre à jour le compte pour que le lien n'existe plus en BDD.
				this.accountDao.update(account);				
				// Mettre à jour le compte pour que le lien n'existe plus en
				// BDD.
				this.accountDao.update(account);
				// Suppression de la carte.
				this.cardDao.delete(cardId);
				
				
				
				
				
				
				
			} else {
				resultOk = false;
			}
		}
		
		if (resultOk) {
			BankCard newCard = new BankCard();
			newCard.setExpirationDate(LocalDate.now().plusMonths(3));
			newCard.setIsElectron(type);
			newCard = this.cardDao.create(newCard);
			account.setCard(newCard);
			this.accountDao.update(account);
		}

		return resultOk;
	}

	public void withdrawCash(float montant) {

	}

	public AccountDao getDao() {
		return this.accountDao;
	}

	// public void update(BankCard newCard) {
	// this.accountDao.update(newCard);
	// }
}
