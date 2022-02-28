package de.telekom.sea7.model.implementation;

import org.springframework.stereotype.Service;

@Service
public class KundeImpl {

	private int kundennummer;
	private String vorname;
	
	public int getKundennummer() {
		return kundennummer;
	}


	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}



	public String getVorname() {
		return vorname;
	}



	public void setVorname(String vorname) {
		this.vorname = vorname;
	}



	
}
