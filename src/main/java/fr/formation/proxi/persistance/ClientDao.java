package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;

/**
 * Classe regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientDao implements Dao<Client> {

	private MySqlConnection mySqlConn;

	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * <br><br>Permet de recuperer les informations d'un client a partir de son id.
	 */
	@Override
	public Client read(Integer id) {
		Client client = null;
		return client;
	}

	/**
	 * {@inheritDoc}
	 * <br><br>Permet de recuperer l'ensemble des clients du conseiller.
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		return clients;
	}
	/**
	 * {@inheritDoc}
	 * <br><br>Met a jour les informations d'un client specifique. Gere la modification du
	 * nom, du prenom, de l'email et de l'adresse du client.
	 */
	@Override
	public Client update(Client entity) {
		return entity;
	}

}
