package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;

/**
 * Classe permettant les opérations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountDao implements Dao<Account> {

	private MySqlConnection mySqlConn;

	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Récupère un compte en particulier à partir de son id.
	 */
	@Override
	public Account read(Integer id) {
		Account account = null;

		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_ACCOUNT_BY_ID_ACCOUNT, id));
			while (rs.next()) {
				Integer idAcc = rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				String savingsString = rs.getString("savings");
				Boolean savings = false;
				if (savingsString.equals("1")) {
					savings = true;
				}
				account = new Account(idAcc, number, balance, savings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	/**
	 * {@inheritDoc}
	 * <br><br>Récupère l'ensemble des comptes enregistrés. Pas encore implémentée car non utilisée par l'application actuellement.
	 */
	@Override
	public List<Account> readAll() {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Recupere l'ensemble des comptes d'un unique client par son id.
	 * 
	 * @param idClient Le client d'intérêt.
	 * @return La liste des comptes du client.
	 */
	public List<Account> readAllAccountsForOneClient(Integer idClient) {
		List<Account> accounts = new ArrayList<>();
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			ResultSet rs = st.executeQuery(String.format(SqlQueries.SELECT_ACCOUNTS_BY_ID, idClient));
			while (rs.next()) {
				Integer idAcc = rs.getInt("id");
				String number = rs.getString("number");
				Float balance = rs.getFloat("balance");
				String savingsString = rs.getString("savings");
				Boolean savings = false;
				if (savingsString.equals("1")) {
					savings = true;
				}
				Account account = new Account(idAcc, number, balance, savings);
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Met à jour les informations d'un compte.
	 */
	@Override
	public Account update(Account entity) {
		try {
			Statement st = this.mySqlConn.getConn().createStatement();
			st.executeUpdate(
					String.format(SqlQueries.UPDATE_ACCOUNT_BALANCE_BY_ID, entity.getBalance(), entity.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

}
