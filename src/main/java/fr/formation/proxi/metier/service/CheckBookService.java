package fr.formation.proxi.metier.service;

import java.time.LocalDate;

import fr.formation.proxi.metier.entity.Account;
import fr.formation.proxi.metier.entity.Check;
import fr.formation.proxi.persistance.ChequeDao;

public class CheckBookService {
	
	private static final CheckBookService INSTANCE = new CheckBookService();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static CheckBookService getInstance() {
		return CheckBookService.INSTANCE;
	}

	private ChequeDao daoCheque;

	public CheckBookService() {
		this.daoCheque = ChequeDao.getInstance();
	}
	
	
	public Check read(Integer id) {	
		return this.daoCheque.read(id);	
	}
	
	

		
		
		
	
		
		

	
	
}
