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
import javax.persistence.Table;

/**
 * Repr�sentation d'un client de la banque.
 */
@Entity
@Table(name="client")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String email;

	@Column(length=200)
	private String address;

	@OneToMany
	@JoinColumn(columnDefinition="id", referencedColumnName="id")
	private List<Account> accounts;

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

	public Client(Integer id, String firstname, String lastname, String email, String address) {
		this(firstname, lastname, email, address);
		this.id = id;
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

}
