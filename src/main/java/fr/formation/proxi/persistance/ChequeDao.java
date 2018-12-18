package fr.formation.proxi.persistance;

import java.util.List;

import fr.formation.proxi.metier.entity.BankCard;
import fr.formation.proxi.metier.entity.Check;

public class ChequeDao extends AbstractDao<Check>{
	
	
	private static final ChequeDao INSTANCE = new ChequeDao();

	public static ChequeDao getInstance() {
		return ChequeDao.INSTANCE;
	}

	public Check read(Integer id) {
		return this.read(id , new Check());

	}


	public List<Check> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
