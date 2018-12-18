package fr.formation.proxi.metier.service;


import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Clsse regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientService {

	private static final ClientService INSTANCE = new ClientService(
			AccountDao.getInstance(), ClientDao.getInstance());
	private ClientDao daoClient;
	private AccountDao daoAccount;

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	public ClientService() {
	}

	public ClientService(AccountDao daoAccount, ClientDao daoClient) {
		this.daoAccount = daoAccount;
		this.daoClient = daoClient;
	}

	/**
	 * Recup�re la liste de tous les clients suivis par le conseiller.
	 * 
	 * @return La liste des clients du conseiller.
	 */
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}

	/**
	 * Permet de faire un virement entre deux comptes d'un même client. Cette
	 * méthode ne fait pas de virement intra-compte ni de virement qui rendrait
	 * le compte débité en solde négatif.
	 * 
	 * @param value         Le montant du virement à effectuer.
	 * @param compteDebite  Le compte à débiter.
	 * @param compteCredite Le compte à créditer
	 * @return False si le virement aurait rendu le compte d�bit� en solde
	 *         n�gatif. True sinon.
	 */
	public boolean transfer(Float value, Integer debitId, Integer creditId,
			Integer clientId) {
		boolean transferOK = true;
		Client client = this.daoClient.read(clientId);
		Account compteDebite = client.getAccountById(debitId);
		Account compteCredite = client.getAccountById(creditId);
		if (compteDebite.getId() == compteCredite.getId()) {
			return transferOK;
		} else if (compteDebite.getBalance() - value < 0) {
			transferOK = false;
			return transferOK;
		} else if (value > 900) {
			transferOK = false;
			return transferOK;
		} else {
			compteCredite.setBalance(compteCredite.getBalance() + value);
			this.daoAccount.update(compteCredite);

			compteDebite.setBalance(compteDebite.getBalance() - value);
			this.daoAccount.update(compteDebite);

			return transferOK;
		}
	}
	
	/**
	 * Permet un retrait de liquide par un client depuis un de ses comptes associés.
	 * Ne permet pas de retraits de plus de 300€, ni de retrait qui rendrait le compte 
	 * en solde négatif.
	 * @param cash
	 * @param accountId
	 * @return
	 */
	public Boolean withdrawCash(float cash, Integer accountId) {
		boolean withdrawOK = true;
		Account compteDebite = this.daoAccount.read(accountId);
		
		if (cash > 300) {
			withdrawOK = false;
			return withdrawOK;
		} else if (compteDebite.getBalance() - cash < 0) {
			withdrawOK = false;
			return withdrawOK;
		} else {
			compteDebite.setBalance(compteDebite.getBalance() - cash);
			this.daoAccount.update(compteDebite);
			return withdrawOK;
		}
		
	}


	/**
	 * Permet de récupérer un client à partir de son id dans la Base De Données.
	 * 
	 * @param id L'id du client à récupérer.
	 * @return Le client.
	 */
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}
	
	/**
	 * Vérification si le nom et prénom rentrés sont conformes à un utilisateur
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	public Client check(String firstname , String lastname) {
		return this.daoClient.check(firstname, lastname);
	}

	/**
	 * Permet de mettre à jour les informations d'un client. Cette m�thode g�re
	 * la modification du nom, du pr�nom, du mail et de l'adresse du client.
	 * 
	 * @param client L'id du client � actualiser.
	 */
	public void update(Client client) {
		this.daoClient.update(client);
	}

	public void setDaoClient(ClientDao daoClient) {
		this.daoClient = daoClient;
	}

	public void setDaoAccount(AccountDao daoAccount) {
		this.daoAccount = daoAccount;
	}

}
