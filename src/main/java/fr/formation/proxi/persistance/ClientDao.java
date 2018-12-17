package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Client;

/**
 * Classe regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientDao extends AbstractDao<Client> {

	private static final ClientDao INSTANCE = new ClientDao();
	
	public static ClientDao getInstance() {
		return ClientDao.INSTANCE;
	}
	
	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer les informations d'un client a partir de son id.
	 */
	@Override
	public Client read(Integer id) {
		return this.read(id, new Client());
	}
	
	
	

	/**
	 * {@inheritDoc} <br>
	 * <br>
	 * Permet de recuperer l'ensemble des clients du conseiller.
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		TypedQuery<Client> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_CLIENT, Client.class);
		clients.addAll(query.getResultList());
		return clients;
	}
	
	
	public Client check(String firstname , String lastname) {
		Client client = new Client();
		TypedQuery<Client> query = this.em
				.createQuery(JpqlQueries.SELECT_CLIENT, Client.class);
		query.setParameter("firstname",firstname);
		query.setParameter("lastname",lastname);
			client = query.getSingleResult();
		return client;
	}
	
	
	

}
