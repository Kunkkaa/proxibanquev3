package fr.formation.proxi.metier.service;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.metier.entity.CurrentAccount;
import fr.formation.proxi.metier.entity.SavingsAccount;
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

	private static final ClientService INSTANCE = new ClientService();
	private final ClientDao daoClient;
	private final AccountDao daoAccount;

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	public ClientService() {
		this.daoClient = new ClientDao();
		this.daoAccount = new AccountDao();
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
	 * Permet de faire un virement entre deux comptes d'un m�me client. Cette
	 * m�thode ne fait pas de virement intra-compte ni de virement qui rendrait le
	 * compte d�bit� en solde n�gatif.
	 * 
	 * @param value         Le montant du virement � effectuer.
	 * @param compteDebite  Le compte � d�biter.
	 * @param compteCredite Le compte � cr�diter
	 * @return False si le virement aurait rendu le compte d�bit� en solde n�gatif.
	 *         True sinon.
	 */
	public boolean transfer(Float value, Account compteDebite, Account compteCredite) {
		boolean transferOK = true;
		if (compteDebite.getId() == compteCredite.getId()) {
			return transferOK;
		} else if (compteDebite.getBalance() - value < 0) {
			transferOK = false;
			return transferOK;
		} else {
			Account compteCrediteActualise;
			if (compteCredite instanceof CurrentAccount) {
				compteCrediteActualise = new CurrentAccount();
			} else {
				compteCrediteActualise = new SavingsAccount();
			}
			compteCrediteActualise.setId(compteCredite.getId());
			compteCrediteActualise.setBalance(compteCredite.getBalance() + value);
			compteCrediteActualise.setNumber(compteCredite.getNumber());
			this.daoAccount.update(compteCrediteActualise);

			Account compteDebiteActualise;
			if (compteDebite instanceof CurrentAccount) {
				compteDebiteActualise = new CurrentAccount();
			} else {
				compteDebiteActualise = new SavingsAccount();
			}
			compteDebiteActualise.setId(compteDebite.getId());
			compteDebiteActualise.setBalance(compteDebite.getBalance() - value);
			compteDebiteActualise.setNumber(compteDebite.getNumber());
			this.daoAccount.update(compteDebiteActualise);
			return transferOK;
		}
	}

	/**
	 * Permet de r�cup�rer un client � partir de son id dans la Base De Donn�es.
	 * 
	 * @param id L'id du client � r�cup�rer.
	 * @return Le client.
	 */
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}

	/**
	 * Permet de mettre � jour les informations d'un client. Cette m�thode g�re la
	 * modification du nom, du pr�nom, du mail et de l'adresse du client.
	 * 
	 * @param client L'id du client � actualiser.
	 */
	public void update(Client client) {
		this.daoClient.update(client);
	}

}
