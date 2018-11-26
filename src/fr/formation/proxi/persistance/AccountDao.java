package fr.formation.proxi.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;

public class AccountDao implements Dao<Account> {

	private MySqlConnection mySqlConn;

	public AccountDao() {
		this.mySqlConn = MySqlConnection.getInstance();
	}

	@Override
	public Account read(Integer id) {
		Account account = null;

		return account;
	}

	@Override
	public List<Account> readAll() {
		return null;
	}

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
