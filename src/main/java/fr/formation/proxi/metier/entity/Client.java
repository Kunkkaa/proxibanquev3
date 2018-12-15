package fr.formation.proxi.metier.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Repr�sentation d'un client de la banque.
 */
// Déclare cette classe en tant qu'entité gérée par JPA/Hibernate.
@Entity
// Déclare le lien avec la table SQL.
@Table(name = "client")
public class Client {

	/**
	 * Définition de l'identifiant JPA correspondant à la clé primaire en SQL.
	 */
	@Id
	// On précise que l'identifiant est une valeur générée par Auto-Increment.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String email;

	@Column(length = 200)
	private String address;

	/*
	 * Déclaration d'une relation de Client 0/1 -> 0/n Account côté Java.
	 * 
	 * Cette relation donne toujours lieu à l'utilisation d'une List Java. Le
	 * lien effectué en base de données est configuré avec l'annotation
	 * suivante.
	 */
	@OneToMany
	/*
	 * Déclaration de la relation Client -> Compte en SQL. Une colonne de
	 * jointure utilisant une clé étrangère sera créée dans la table account.
	 * 
	 * 'columnDefinition' -> nom de l'attribut Java qui détermine l'identifiant
	 * de ma classe Client.
	 * 
	 * 'referencedColumnName' -> nom de l'attribut Java qui détermine
	 * l'identifiant de la classe cible Account.
	 * 
	 * 'name' -> nom de la colonne SQL de jointure comportant la clé étrangère.
	 * On conserve le nom 'accounts_id' choisi par Hibernate.
	 */
	@JoinColumn(name = "accounts_id", referencedColumnName = "id")
	private List<Account> accounts;
	
	
	@OneToOne
	// Pour un OneToOne avec Hibernate 5 et MySQL 8 la clé étrangère sera dans la table client.
	@JoinColumn(name="card_id", referencedColumnName="id")
	private BankCard card;

	public BankCard getCard() {
		return card;
	}

	public void setCard(BankCard card) {
		this.card = card;
	}

	public Client() {
		this.accounts = new ArrayList<>();
	}

	public Client(String firstname, String lastname, String email,
			String address) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
	}

	public Client(Integer id, String firstname, String lastname, String email,
			String address) {
		this(firstname, lastname, email, address);
		this.id = id;
	}

	public Client(Integer id, String firstname, String lastname, String email,
			String address, List<Account> accounts) {
		this(id, firstname, lastname, email, address);
		this.accounts = accounts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccountById(Integer searchId) {
		Account result = null;
		for (Account a : this.accounts) {
			if (a.getId().equals(searchId)) {
				result = a;
				break;
			}
		}
		return result;
	}

}
