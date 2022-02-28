package de.telekom.sea7.model;

public interface Zahlung {

	// Get-Methoden
	String getEmpfaenger();
	String getEmpfaengerIBAN();
	String getEmpfaengerBIC();
	double getBetrag();
	String getWaehrung();
	String getVerwendungszweck();
	
	// Set-Methoden
	void setEmpfaenger(String empfaenger);
	void setEmpfaengerIBAN(String empfaengerIBAN);
	void setEmpfaengerBIC(String empfaengerBIC);
	void setBetrag(double betrag);
	void setWaehrung(String waehrung);
	void setVerwendungszweck(String verwendungszweck);
	
}
