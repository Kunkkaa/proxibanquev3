package fr.formation.proxi.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name= "address" )





public class Address {
	
	@Id
	// On précise que l'identifiant est une valeur générée par Auto-Increment.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	
	private Integer id;
	
	@Column
	private String field1;
	
	@Column
	private String field2;
	
	@Column
	private String town;
	
	@Column
	private String porstalCode;
	
	@Column
	private String country;
	
	
	
	
	
	public Address(){
		
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getPorstalCode() {
		return porstalCode;
	}

	public void setPorstalCode(String porstalCode) {
		this.porstalCode = porstalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address( String field1, String field2, String town, String porstalCode, String country) {
		this.field1 = field1;
		this.field2 = field2;
		this.town = town;
		this.porstalCode = porstalCode;
		this.country = country;
	}

	
	

}
