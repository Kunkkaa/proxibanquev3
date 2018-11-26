package fr.formation.proxi.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static final MySqlConnection INSTANCE = new MySqlConnection();

	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private Connection conn;
	
	private boolean isConnected;

	public Connection getConn() {
		return conn;
	}

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
