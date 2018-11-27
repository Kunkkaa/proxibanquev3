package fr.formation.proxi.metier.service;

import java.util.List;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Client;
import fr.formation.proxi.persistance.AccountDao;
import fr.formation.proxi.persistance.ClientDao;

/**
 * Clsse regroupant les traitements à effectuer sur les clients. Respecte le
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
	 * Recupère la liste de tous les clients suivis par le conseiller.
	 * 
	 * @return La liste des clients du conseiller.
	 */
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}

	/**
	 * Permet de faire un virement entre deux comptes d'un même client. Cette
	 * méthode ne fait pas de virement intra-compte ni de virement qui rendrait le
	 * compte débité en solde négatif.
	 * 
	 * @param value         Le montant du virement à effectuer.
	 * @param compteDebite  Le compte à débiter.
	 * @param compteCredite Le compte à créditer
	 * @return False si le virement aurait rendu le compte débité en solde négatif.
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
			Account compteCrediteActualise = new Account(compteCredite.getId(), compteCredite.getNumber(),
					(compteCredite.getBalance() + value), compteCredite.isSavings());
			this.daoAccount.update(compteCrediteActualise);

			Account compteDebiteActualise = new Account(compteDebite.getId(), compteDebite.getNumber(),
					(compteDebite.getBalance() - value), compteDebite.isSavings());
			this.daoAccount.update(compteDebiteActualise);
			return transferOK;
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
	 * Permet de mettre à jour les informations d'un client. Cette méthode gère la
	 * modification du nom, du prénom, du mail et de l'adresse du client.
	 * 
	 * @param client L'id du client à actualiser.
	 */
	public void update(Client client) {
		this.daoClient.update(client);
	}

}
