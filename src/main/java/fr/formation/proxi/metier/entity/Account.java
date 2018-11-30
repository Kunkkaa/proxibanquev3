package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Representation d'un compte bancaire generique.
 */
@Entity
@Table(name="account")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="savings")
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

	public Account() {
		this.balance = 0F;
	}

	public Account(String number, Float balance) {
		this();
		this.number = number;
		this.balance = balance;
	}

	public Account(Integer id, String number, Float balance) {
		this(number, balance);
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

}
