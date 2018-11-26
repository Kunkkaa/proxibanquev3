package fr.formation.proxi.persistance;

public class SqlQueries {
	
	public static final String SELECT_ALL_CLIENTS = "SELECT * FROM client";
	public static final String SELECT_CLIENT_BY_ID = "SELECT * FROM client WHERE id = %s";
	public static final String SELECT_ACCOUNTS_BY_ID = "SELECT account.number, account.balance, account.savings FROM account JOIN client ON account.id_client = client.id WHERE client.id = %s";
	public static final String UPDATE_ACCOUNT_BALANCE_BY_ID = "UPDATE account SET balance = %s WHERE id = %s";
}
