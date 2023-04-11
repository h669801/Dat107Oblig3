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
	
	@Id private Integer avdeling_id;
	private String avdelingsnavn;
	private String sjef_id;
	
	public Avdeling() {
		
	}

    public Avdeling(int avdeling_id, String avdelingsnavn, String sjef_id) {
		super();
		this.avdeling_id = avdeling_id;
		this.avdelingsnavn = avdelingsnavn;
		this.sjef_id = sjef_id;
	}
	public int getId() {
		return avdeling_id;
	}

	public void setId(int id) {
		this.avdeling_id = id;
	}

	public String getavdelingsnavn() {
		return avdelingsnavn;
	}

	public void setavdelingsnavn(String avdelingsnavn) {
		this.avdelingsnavn = avdelingsnavn;
	}
	
//	public String getEtterNavn() {
//		return etternavn;
//	}
//
//	public void setEtterNavn(String etternavn) {
//		this.etternavn = etternavn;
//	}

//	public List<Ansatt> getAnsatte() {
//		return ansatte;
//	}
//
//	public void setAnsatte(List<Ansatt> ansatte) {
//		this.ansatte = ansatte;
//	}

	public String getSjef() {
		return sjef_id;
	}

	public void setSjef(String sjef_id) {
		this.sjef_id = sjef_id;
	}
}
