package fr.formation.proxi.metier.service;

import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.persistance.BankCardDao;

public class BankCardService {

	private static final BankCardService INSTANCE = new BankCardService();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static BankCardService getInstance() {
		return BankCardService.INSTANCE;
	}

	private BankCardDao daoCard;

	public BankCardService() {
		this.daoCard = BankCardDao.getInstance();
	}

	
	public BankCard create(String number, String isElectron) {
		return this.daoCard.create(new BankCard(number, isElectron));
	}

	public void delete(Integer id) {
		this.daoCard.delete(id);
	}


	public BankCard read(Integer id) {
		return this.daoCard.read(id);
	}
}
