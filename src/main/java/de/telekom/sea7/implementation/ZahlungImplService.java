package de.telekom.sea7.implementation;
import org.springframework.stereotype.Service;


@Service // Component-Annotation um die Klasse als BackEnd Service Klasse zu kennzeichnen 
public class ZahlungImplService  {
	
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
