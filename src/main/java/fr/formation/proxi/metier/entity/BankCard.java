package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankcard")
public class BankCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String number;
	
	@Column
	private Boolean isElectron;
	
	public BankCard() {
	}
	
	public BankCard(String number, Boolean isElectron) {
		this.number = number;
		this.isElectron = isElectron;
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

	public Boolean getIsElectron() {
		return isElectron;
	}

	public void setIsElectron(Boolean isElectron) {
		this.isElectron = isElectron;
	}


	
}
