package tabeller;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "obl3")
public class Avdeling {

//	DROP SCHEMA IF EXISTS Obl3 CASCADE;
//	CREATE SCHEMA Obl3;
//	SET search_path TO Obl3;
	
//	CREATE TABLE Avdeling (
//			id SERIAL PRIMARY KEY,
//			fornavn VARCHAR(35) NOT NULL,
//			etternavn VARCHAR (35) NOT NULL,
//			avdeling VARCHAR(50) NOT NULL
//				);
	
//	ALTER TABLE Avdeling 
//	ADD CONSTRAINT fk_sjef 
//	FOREIGN KEY (sjef_id) 
//	REFERENCES Ansatt (id);
	
	@Id private Integer id;
	private String fornavn;
	private String etternavn;
	private String sjef;

    public Avdeling(int id, String fornavn, String etternavn, String sjef) {
		super();
		this.id = id;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.sjef = sjef;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForNavn() {
		return fornavn;
	}

	public void setForNavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtterNavn() {
		return etternavn;
	}

	public void setEtterNavn(String etternavn) {
		this.etternavn = etternavn;
	}

//	public List<Ansatt> getAnsatte() {
//		return ansatte;
//	}
//
//	public void setAnsatte(List<Ansatt> ansatte) {
//		this.ansatte = ansatte;
//	}

	public String getSjef() {
		return sjef;
	}

	public void setSjef(String sjef) {
		this.sjef = sjef;
	}
}
