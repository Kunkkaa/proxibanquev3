package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;

/**
 * Classe regroupant les traitements à effectuer sur les clients. Respecte le
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
	 * <br><br>Permet de récupérer les informations d'un client à partir de son id.
	 */
	@Override
	public Client read(Integer id) {

		Client client = null;

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_CLIENT_BY_ID, id));
			while (rs.next()) {
				Integer idcli = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				client = new Client(firstname, lastname, email, address);
				client.setId(idcli);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

	/**
	 * {@inheritDoc}
	 * <br><br>Permet de récupérer l'ensemble des clients du conseiller.
	 */
	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(SqlQueries.SELECT_ALL_CLIENTS);
			while (rs.next()) {
				Integer idcli = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address = rs.getString("address");
				Client client = new Client(firstname, lastname, email, address);
				client.setId(idcli);
				clients.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;
	}
	/**
	 * {@inheritDoc}
	 * <br><br>Met à jour les informations d'un client spécifique. Gère la modification du
	 * nom, du prénom, de l'email et de l'adresse du client.
	 */
	@Override
	public Client update(Client entity) {
		
		entity.setFirstname(entity.getFirstname().replaceAll("\'", "\'\'"));
		entity.setLastname(entity.getLastname().replaceAll("\'", "\'\'"));
		entity.setEmail(entity.getEmail().replaceAll("\'", "\'\'"));
		entity.setAddress(entity.getAddress().replaceAll("\'", "\'\'"));

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			st.executeUpdate(String.format(SqlQueries.UPDATE_CLIENT, entity.getLastname(), entity.getFirstname(),
					entity.getEmail(), entity.getAddress(), entity.getId()));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
