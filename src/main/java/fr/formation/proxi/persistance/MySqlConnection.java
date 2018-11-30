package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe permettant de se lier a  la base de donnees MySQL. 
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
	 * Methode qui permet de recuperer la connection etablie par la classe.
	 * Ne prend pas de parametres.
	 * @return La connection Ã  la BDD MySQL.
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Constructeur de classe qui permet la connexion a  la base de donnees. 
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
