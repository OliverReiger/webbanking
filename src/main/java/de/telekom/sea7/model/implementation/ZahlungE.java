package de.telekom.sea7.model.implementation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZahlungE {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="empfaenger")
	private String empfaenger;
	@Column(name="empfaengerIBAN")
	private String empfaengerIBAN;
	@Column(name="empfaengerBIC")
	private String empfaengerBIC;
	@Column(name="betrag")
	private double betrag;
	@Column(name="waehrung")
	private String waehrung;
	@Column(name="verwendungszweck")
	private String verwendungszweck;
	
	public ZahlungE() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpfaenger() {
		return empfaenger;
	}

	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	public String getEmpfaengerIBAN() {
		return empfaengerIBAN;
	}

	public void setEmpfaengerIBAN(String empfaengerIBAN) {
		this.empfaengerIBAN = empfaengerIBAN;
	}

	public String getEmpfaengerBIC() {
		return empfaengerBIC;
	}

	public void setEmpfaengerBIC(String empfaengerBIC) {
		this.empfaengerBIC = empfaengerBIC;
	}

	public double getBetrag() {
		return betrag;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public String getWaehrung() {
		return waehrung;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public String getVerwendungszweck() {
		return verwendungszweck;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

}
