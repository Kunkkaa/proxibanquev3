package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe permettant de se lier à la base de données MySQL. 
 * Cette classe est un singleton.
 * @author Adminl
 *
 */
public class MySqlConnection {

	public static final MySqlConnection INSTANCE = new MySqlConnection();

	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private Connection conn;
	
	private boolean isConnected;

	/**
	 * Méthode qui permet de récupérer la connection établie par la classe.
	 * Ne prend pas de paramètres.
	 * @return La connection à la BDD MySQL.
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Constructeur de classe qui permet la connexion à la base de données. 
	 */
	public MySqlConnection() {
		this.isConnected = true;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proxi2?serverTimezone=Europe/Paris",
					"root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			this.isConnected = false;
			e.printStackTrace();
		}

	}

}
