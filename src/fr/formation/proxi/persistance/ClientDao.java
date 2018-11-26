package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Client;

public class ClientDao implements Dao<Client>{

	private MySqlConnection mySqlConn;

	public ClientDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}

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

	public Client update(Client entity) {

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			st.executeUpdate(String.format(
					SqlQueries.UPDATE_CLIENT, entity.getLastname(), entity.getFirstname(), entity.getEmail(), entity.getAddress(), entity.getId()));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity; 
		
		
	}

}
