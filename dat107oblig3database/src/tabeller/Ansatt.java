package tabeller;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Oblig3")
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
	
	
	private Integer id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private String dato;
	private int maanedslonn;
	private String avdeling;
	private String prosjekt;
	
	public Ansatt() {
		
	}
	
	public Ansatt(Integer id, String brukernavn, String fornavn, String etternavn, String dato, int maanedslonn, String avdeling, String prosjekt) {
		this.id = id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.dato = dato;
		this.avdeling = avdeling;
		this.prosjekt = prosjekt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public String getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(String avdeling) {
		this.avdeling = avdeling;
	}

	public String getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(String prosjekt) {
		this.prosjekt = prosjekt;
	}
	
//	public void skrivUt() {
//		System.out.println("Id :" + id)
//	}

	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", dato=" + dato + ", maanedslonn=" + maanedslonn + ", avdeling=" + avdeling + ", prosjekt="
				+ prosjekt + "]";
	}
}
