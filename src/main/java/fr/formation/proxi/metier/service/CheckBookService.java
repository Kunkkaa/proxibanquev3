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
	
	/**
	 * Redéfinition de la méthode read pour vérifier l'existence d'un chéquier
	 * @param id
	 * @return
	 */
	public Check read(Integer id) {	
		return this.daoCheque.read(id);	
	}
	

	/**
	 * Tentative de création d'un chéquier client. La méthode retournera true si et seulement si 
	 * l'ancienne acquisition de chéquier est supérieure à 3 mois.
	 * @param account
	 * @return status un objet de la classe Cheque Status, constitué d'un booléen et d'un message.
	 */
	public ChequeStatus statusCheque(Account account) {
		Check cheque = account.getCheck();
		ChequeStatus status = null;
		
		if(cheque == null) {
			
			 status = new ChequeStatus("Premier chequier en cours de distribution...", true);
			
		} else if (cheque.getreceptionDate().plusMonths(3).isBefore(LocalDate.now()) ) {
			
			status = new ChequeStatus("Nouveau chéquier valable jusqu’au" + cheque.getreceptionDate() + "en cours de distribution…" , true );
			
		} else {
			
			status = new ChequeStatus(" Impossible d’effectuer le retrait d’un nouveau chéquier pour ce compte avant le " + cheque.getreceptionDate().plusMonths(3) , false );
			
		}
		
		return status;
}

		
		
		
	
		
		

	
	
}
