package fr.formation.proxi.persistance;

import java.util.List;

import fr.formation.proxi.metier.entity.BankCard;

public class CardDao  extends AbstractDao<BankCard>{
	
	
	private static final CardDao INSTANCE = new CardDao();

	public static CardDao getInstance() {
		return CardDao.INSTANCE;
	}

	@Override
	public BankCard read(Integer id) {
		return this.read(id , new BankCard());

	}

	@Override
	public List<BankCard> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
