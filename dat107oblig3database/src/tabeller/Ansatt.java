package tabeller;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "obl3")
public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;

//	@Temporal(TemporalType.DATE)
	private java.sql.Date ansettelsesdato;

	@ManyToOne
	@JoinColumn(name = "Avd_id")
	private Avdeling avdeling;

	private String stilling;
	private Double maanedslonn;

	public Ansatt() {

	}

	public Ansatt(String brukernavn, String fornavn, String etternavn, java.sql.Date ansettelsesdato, String stilling,
			Double maanedslonn, Avdeling avdeling) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesdato = ansettelsesdato;
		this.maanedslonn = maanedslonn;
		this.stilling = stilling;
		this.avdeling = avdeling;
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

	public java.sql.Date getDato() {
		return ansettelsesdato;
	}

	public void setDato(Date dato) {
		this.ansettelsesdato = dato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public Double getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(Double maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

	public String toString() {
		return "Ansatt [id = " + id + ", brukernavn = " + brukernavn + ", fornavn = " + fornavn + ", etternavn = " + etternavn
				+ ", dato = " + ansettelsesdato + ", maanedslonn = " + maanedslonn + "]";
	}

	public void skrivUt() {
		System.out.println(toString());
	}
}
