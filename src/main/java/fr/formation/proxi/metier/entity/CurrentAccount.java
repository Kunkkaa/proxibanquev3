package fr.formation.proxi.metier.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
// Valeur de la colonne 'savings' de la table account permettant d'identifier un compte comme étant un compte courant.
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {
	
	@OneToOne
	@JoinColumn(name="card_id", referencedColumnName="id")
	private BankCard card;

	public CurrentAccount() {
		
	}
	
	
	
	public CurrentAccount(Integer id, String number, String openingDate, String label, Float balance, Check check,
			BankCard card) {
		super(id, number, openingDate, label, balance, check);
		this.card = card;
	}

	
	
	public BankCard getCard() {
		return card;
	}

	public void setCard(BankCard card) {
		this.card = card;
	}
	
	

}
