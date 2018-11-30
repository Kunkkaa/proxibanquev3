package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representation d'un compte bancaire generique.
 */
@Entity
@Table(name="account")
public class Account {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	/**
	 * Identifiant meier, numero du compte sur 9 chiffres.
	 */
	@Column
	private String number;

	/**
	 * Stockage du solde actuel de ce compte en euros.
	 */
	@Column
	private Float balance;

	/**
	 * Si vrai, c'est un compte epargne, sinon c'est un compte courant.
	 */
	@Column
	private Boolean savings;

	public Account() {
		this.savings = false;
		this.balance = 0F;
	}

	public Account(String number, Float balance) {
		this();
		this.number = number;
		this.balance = balance;
	}

	public Account(String number, Float balance, boolean savings) {
		this(number, balance);
		this.savings = savings;
	}
	
	public Account(Integer id, String number, Float balance, boolean savings) {
		this(number, balance, savings);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	public Boolean isSavings() {
		return savings;
	}

	public void setSavings(Boolean savings) {
		this.savings = savings;
	}

}
