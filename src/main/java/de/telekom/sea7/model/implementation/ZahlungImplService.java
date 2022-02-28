package de.telekom.sea7.model.implementation;

import org.springframework.stereotype.Service;

import de.telekom.sea7.model.Zahlung;

@Service // Component-Annotation um die Klasse als BackEnd Service Klasse zu kennzeichnen
public class ZahlungImplService implements Zahlung {

	// Properties
	private String empfaenger;
	private String empfaengerIBAN;
	private String empfaengerBIC;
	private double betrag;
	private String waehrung;
	private String verwendungszweck;
	
	// Get-/Set-Methoden
	public String getEmpfaenger() {
		return empfaenger;
	}

	public String getEmpfaengerIBAN() {
		return empfaengerIBAN;
	}
	
	public String getEmpfaengerBIC() {
		return empfaengerBIC;
	}
	
	public double getBetrag() {
		return betrag;
	}
	
	public String getWaehrung() {
		return waehrung;
	}
	
	public String getVerwendungszweck() {
		return verwendungszweck;
	}
	
	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}

	public void setEmpfaengerIBAN(String empfaengerIBAN) {
		this.empfaengerIBAN = empfaengerIBAN;
	}

	public void setEmpfaengerBIC(String empfaengerBIC) {
		this.empfaengerBIC = empfaengerBIC;
	}

	public void setBetrag(double betrag) {
		this.betrag = betrag;
	}

	public void setWaehrung(String waehrung) {
		this.waehrung = waehrung;
	}

	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}

}
