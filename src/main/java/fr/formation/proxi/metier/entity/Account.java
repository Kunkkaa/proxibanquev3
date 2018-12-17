package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Representation d'un compte bancaire generique.
 */
//Déclare cette classe en tant qu'entité gérée par JPA/Hibernate.
@Entity
// Lien avec la table SQL unique.
@Table(name = "account")
// Déclaration d'une hierarchie dans les clases Java d'entité.
// La stratégie SINGLE_TABLE précise qu'il n'y aura toujours qu'une seule table SQL pour tous les types de comptes.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Déclare la colonne SQL à utiliser pour différencier les sous-classes de Account (soit CurrentAccount ou SavingsAccount).
@DiscriminatorColumn(name = "savings")
/*
 * L'annotation ci-dessous est désactivée car elle ne fonctionne que si la
 * classe mère Account n'est JAMAIS utilisée dans les entités. Or on l'utilise
 * dans la classe Client avec List<Account>. On doit donc utiliser @Entity à la
 * place. Il ne peut il y avoir qu'une des deux annotations @Entity
 * ou @MappedSuperclass sur une entité JPA.
 */
//@MappedSuperclass
public class Account {

	/**
	 * Identifiant technique base de donnees.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * Date d'ouverture Client 
	 */
	
	private String openingDate;
	
	/**
	 * Libellé de compte
	 */
	private String label;
	
	@OneToOne 
	
	@JoinColumn(name="check_id" ,referencedColumnName="id")
	private Check check;
	
	
	public Account(Integer id, String number, String openingDate, String label, Float balance , Check check) {
		this.id = id;
		this.number = number;
		this.openingDate = openingDate;
		this.label = label;
		this.balance = balance;
		this.check = check;
	}
	
	

	public String getOpeningDate() {
		return openingDate;
	}

	public Check getCheck() {
		return check;
	}



	public void setCheck(Check check) {
		this.check = check;
	}



	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}





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
