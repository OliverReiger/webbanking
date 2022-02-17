package de.telekom.sea7.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.stereotype.Service;

@Service // Component-Annotation um die Klasse als BackEnd Service Klasse zu kennzeichnen 
public class ZahlungenImplService {

	// Propertie zur Verwaltung mehrerer Zahlung-Objekte
	private ArrayList<ZahlungImplService> zahlungen = new ArrayList<>();
	
	// Add Methode um Zahlungen dem Array hinzuzufügen
	public void add(ZahlungImplService zahlung) {
		zahlungen.add(zahlung);
	}
	
	// Iterator Methode
	public Iterator iterator() {
		return zahlungen.iterator();
	}
	
	public int size() {
		return zahlungen.size();
	}
	
	public ZahlungImplService get(int position) throws Exception {
	if (zahlungen.size() <= position && zahlungen.size() >=0 ) {
		return zahlungen.get(position);	
	} else {
		throw new Exception();
		}
	}
	
	public int getIndex(ZahlungImplService zahlung) {
		return this.zahlungen.indexOf(zahlung);
	}
	
	public ZahlungImplService getZahlung(int index) {
		return (ZahlungImplService) zahlungen.get(index);
	}
}
