package fr.formation.proxi.metier.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cheque")
public class Check {
	
	
	@Id
	// On précise que l'identifiant est une valeur générée par Auto-Increment.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String sendDate;
	
	@Column
	private LocalDate receptionDate;
	
	
	
	public Check() {
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getsendDate() {
		return sendDate;
	}

	public void setsendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public LocalDate getreceptionDate() {
		return receptionDate;
	}

	public void setreceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}

	public Check(Integer id, String sendDate, LocalDate receptionDate) {
		this.id = id;
		this.sendDate = sendDate;
		this.receptionDate = receptionDate;
	}


	
	
	

}
