package fr.formation.proxi.persistance;


/**
 * Classe contenant sous forme de constantes l'ensemble des requêtes nécessaires aux manipulations de la base de données.
 * 
 * @author Adminl
 *
 */
public class SqlQueries {
	
	public static final String SELECT_ALL_CLIENTS = "SELECT * FROM client";
	public static final String SELECT_CLIENT_BY_ID = "SELECT * FROM client WHERE id = %s";
	public static final String SELECT_ACCOUNTS_BY_ID = "SELECT account.id, account.number, account.balance, account.savings FROM account JOIN client ON account.id_client = client.id WHERE client.id = %s";
	public static final String SELECT_ACCOUNT_BY_ID_ACCOUNT = "SELECT account.id, account.number, account.balance, account.savings FROM account WHERE id = %s";
	public static final String UPDATE_ACCOUNT_BALANCE_BY_ID = "UPDATE account SET balance = %s WHERE id = %s";
	public static final String UPDATE_CLIENT = "UPDATE client SET lastname = '%s', firstname = '%s', email = '%s', address = '%s' WHERE id = %s";
}
