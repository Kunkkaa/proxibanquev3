package fr.formation.proxi.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxi.metier.entity.Account;

/**
 * Classe permettant les op�rations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountDao extends AbstractDao<Account> {
	
	private static final AccountDao INSTANCE = new AccountDao();
	
	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 * <br><br>Recupere un compte en particulier à partir de son id.
	 */
	@Override
	public Account read(Integer id) {
		return this.read(id, new Account());
	}
	
	/**
	 * {@inheritDoc}
	 * <br><br>Recupère l'ensemble des comptes enregistrés. Pas encore implementee car non utilisee par l'application actuellement.
	 */
	@Override
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em
				.createQuery(JpqlQueries.SELECT_ALL_ACCOUNT, Account.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}
	
}
