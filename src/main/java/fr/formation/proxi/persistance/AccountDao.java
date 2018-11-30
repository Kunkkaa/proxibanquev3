package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import fr.formation.proxi.metier.entity.Account;

/**
 * Classe permettant les op�rations du C.R.U.D pour les comptes des clients.
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
	 * <br><br>Recupere un compte en particulier � partir de son id.
	 */
	@Override
	public Account read(Integer id) {
		Account account = null;
		return account;
	}
	/**
	 * {@inheritDoc}
	 * <br><br>Recupere l'ensemble des comptes enregistres. Pas encore implementee car non utilisee par l'application actuellement.
	 */
	@Override
	public List<Account> readAll() {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Recupere l'ensemble des comptes, epargne et courant, d'un unique client par son id.
	 * 
	 * @param idClient Le client d'interet.
	 * @return La liste des comptes du client.
	 */
	public List<Account> readAllAccountsForOneClient(Integer idClient) {
		List<Account> accounts = new ArrayList<>();
		return accounts;
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Met � jour le solde d'un compte.
	 */
	@Override
	public Account update(Account entity) {
		return entity;
	}

}
