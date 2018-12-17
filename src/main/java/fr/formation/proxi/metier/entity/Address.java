package fr.formation.proxi.metier.entity;

public class Address {
	
	
	private String number; 
	
	private String field1;
	
	private String field2;
	
	private String town;
	
	private String porstalCode;
	
	private String Country;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Address(String number, String field1, String field2, String town, String porstalCode, String country) {
		this.number = number;
		this.field1 = field1;
		this.field2 = field2;
		this.town = town;
		this.porstalCode = porstalCode;
		Country = country;
	}

	
	

}
