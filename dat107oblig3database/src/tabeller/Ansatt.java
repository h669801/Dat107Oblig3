package tabeller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "obl3")
public class Ansatt {
	
	
//	CREATE TABLE ansatt (
//		id SERIAL PRIMARY KEY,
//		brukernavn VARCHAR(20) UNIQUE NOT NULL,
//		fornavn VARCHAR(35) NOT NULL,
//		etternavn VARCHAR (35) NOT NULL,
//		ansettelsesdato DATE NOT NULL,
//		stilling VARCHAR(50) NOT NULL,
//		maanedslonn DECIMAL (10,2) NOT NULL
//			);
	
//	DROP SCHEMA IF EXISTS Obl3 CASCADE;
//	CREATE SCHEMA Obl3;
//	SET search_path TO Obl3;
//
//	CREATE TABLE ansatt (
//			id SERIAL PRIMARY KEY,
//			brukernavn VARCHAR(20) UNIQUE NOT NULL,
//			fornavn VARCHAR(35) NOT NULL,
//			etternavn VARCHAR (35) NOT NULL,
//			ansettelsesdato DATE NOT NULL,
//			stilling VARCHAR(50) NOT NULL,
//			maanedslonn DECIMAL (10,2) NOT NULL
//				);
	
//	DROP SCHEMA IF EXISTS Obl3 CASCADE;
//	CREATE SCHEMA Obl3;
//	SET search_path TO Obl3;
//
//	CREATE TABLE ansatt (
//			id SERIAL PRIMARY KEY,
//			brukernavn VARCHAR(20) UNIQUE NOT NULL,
//			fornavn VARCHAR(35) NOT NULL,
//			etternavn VARCHAR (35) NOT NULL,
//			ansettelsesdato DATE NOT NULL,
//			stilling VARCHAR(50) NOT NULL,
//			maanedslonn DECIMAL (10,2) NOT NULL,
//			prosjekt VARCHAR(50) NOT NULL,
//			avdeling VARCHAR(50) NOT NULL
//				);
	
//	CREATE TABLE Avdeling (
//	avd_id SERIAL PRIMARY KEY,
//	avdeling VARCHAR(50) NOT NULL
//		);
//	
//	INSERT INTO ansatt (id, brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn, prosjekt, avdeling) VALUES
//	(1, 'bruker1' ,'Per', 'Andersen', '2020-01-01', 'stilling 1' , 25000, 'prosjekt1', 'avdeling1'),
//	(2, 'bruker2' ,'Fridtjof', 'Hammer', '2015-01-01', 'stilling 8', 80000, 'prosjekt2', 'avdeling1'),
//	(3, 'bruker3' ,'Ole', 'mann', '2014-01-01', 'stilling 5', 40000, 'prosjekt3', 'avdeling1');
//	(4, 'bruker4' ,'Ola', 'inga', '2012-01-01', 'stilling 5', 40000, 'prosjekt2', 'avdeling2');
//	(5, 'bruker5' ,'Ola', 'Rønningen', '2014-01-01', 'stilling 1', 25000, 'prosjekt3', 'avdeling1');
//	(6, 'bruker6' ,'Ola', 'Nord', '2016-01-01', 'stilling 1', 25000, 'prosjekt2', 'avdeling1');
//	(7, 'bruker7' ,'Ola', 'Nordmann', '2015-01-01', 'stilling 1', 25000, 'prosjekt1', 'avdeling1');
//	(8, 'bruker8' ,'Ola', 'Eliassen', '2017-01-01', 'stilling 1', 25000, 'prosjekt1', 'avdeling1');
//	(9, 'bruker9' ,'Ola', 'behre', '2018-01-01', 'stilling 8', 80000, 'prosjekt1', 'avdeling1');
//	(10, 'bruker10' ,'Ola', 'Brosvik', '2019-01-01', 'stilling 5', 40000, 'prosjekt3', 'avdeling3');
	
//	INSERT INTO Avdeling (avd_id, avdeling) VALUES
//	(1, 'avdeling1');
//	(2, 'avdeling2');
//	(3, 'avdeling3');
	
	
    @Id private Integer ansatt_id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private String ansettelsesdato;
	private String stilling;
	private int maanedslonn;
//	private String avdeling;
//	private String prosjekt;
	
	public Ansatt() {
		
	}
	
	public Ansatt(Integer ansatt_id, String brukernavn, String fornavn, String etternavn, String ansettelsesdato, String stilling, int maanedslonn) {
		this.ansatt_id = ansatt_id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansettelsesdato;
		this.stilling = stilling;
//		this.avdeling = avdeling;
//		this.prosjekt = prosjekt;
	}

	public Integer getId() {
		return ansatt_id;
	}

	public void setId(Integer ansatt_id) {
		this.ansatt_id = ansatt_id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getDato() {
		return ansettelsesdato;
	}

	public void setDato(String dato) {
		this.ansettelsesdato = dato;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

//	public String getAvdeling() {
//		return avdeling;
//	}
//
//	public void setAvdeling(String avdeling) {
//		this.avdeling = avdeling;
//	}
//
//	public String getProsjekt() {
//		return prosjekt;
//	}
//
//	public void setProsjekt(String prosjekt) {
//		this.prosjekt = prosjekt;
//	}
	
//	public void skrivUt() {
//		System.out.println("Id :" + id)
//	}

	  public String toString() {
		return "Ansatt [id=" + ansatt_id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", dato=" + ansettelsesdato + ", maanedslonn=" + maanedslonn + "]";
	}
	  public void skrivUt() {
		  System.out.println(toString());
	  }
}
