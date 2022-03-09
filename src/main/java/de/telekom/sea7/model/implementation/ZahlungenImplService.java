package de.telekom.sea7.model.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.stereotype.Service;

import de.telekom.sea7.model.Zahlung;
import de.telekom.sea7.model.Zahlungen;

@Service // Component-Annotation um die Klasse als BackEnd Service Klasse zu kennzeichnen 
public class ZahlungenImplService implements Zahlungen {

	// Propertie zur Verwaltung mehrerer Zahlung-Objekte
	private ArrayList<Zahlung> zahlungen = new ArrayList<>();
	
	// Methode zum Anfügen von x-Anzahl Testdaten an ein Array
	public void addTestzahlungen(int anzahl) {
		int tester = 1;
		for (int i=0; i < anzahl; i++) {
			Zahlung testdata = new ZahlungImplService();
			testdata.setEmpfaenger("Tester ArrayList " + tester);
			testdata.setEmpfaengerIBAN("DEIBANTEST " + tester);
			testdata.setEmpfaengerBIC("BICTEST " + tester);
			testdata.setBetrag(tester+tester+tester + 0.95);
			testdata.setWaehrung("Euro");
			testdata.setVerwendungszweck("Test Zweck " + tester);
			zahlungen.add(testdata);
			tester++;
		}
	}
	
	public double summeArrayList() {
		double umsatz = 0;
			Iterator<Zahlung> tempZahlungIterator = zahlungen.iterator();
				while(tempZahlungIterator.hasNext()) {
				Zahlung tempZahlung = tempZahlungIterator.next();
				double neuerUmsatz = tempZahlung.getBetrag();
				umsatz = umsatz + neuerUmsatz; 
			}
			return umsatz;
	}
	
	public String summeFuerChart() {
		double umsatzPeggy = 0;
		double umsatzFranzi = 0;
		double umsatzOli = 0;
		double umsatzMarco = 0;
		double umsatzElisabeth = 0;
		double umsatzThorsten = 0;
		double umsatzRobert = 0;
		double umsatzMichael = 0;
		
		double umsatzEckard = 0;
		double umsatzHolger = 0;
		double umsatzChristof = 0;
		double umsatzAndre = 0;
		double umsatzFelix = 0;
		
		String ergebnis = "";
			Iterator<Zahlung> tempZahlungIterator = zahlungen.iterator();
			
			while(tempZahlungIterator.hasNext()) {
			
				Zahlung tisch = tempZahlungIterator.next();
				
				double neuerUmsatz = tisch.getBetrag();
				String neuerName = tisch.getEmpfaenger();
				
				if (neuerName.equals("Peggy")) {
					umsatzPeggy = umsatzPeggy + neuerUmsatz; 
				} else if (neuerName.equals("Franzi")) {
					umsatzFranzi = umsatzFranzi + neuerUmsatz;
				} else if (neuerName.equals("Oli")) {
					umsatzOli = umsatzOli + neuerUmsatz;
				} else if (neuerName.equals("Marco")) {
					umsatzMarco = umsatzMarco + neuerUmsatz;
				} else if (neuerName.equals("Elisabeth")) {
					umsatzElisabeth = umsatzElisabeth + neuerUmsatz;
				} else if (neuerName.equals("Thorsten")) {
					umsatzThorsten = umsatzThorsten + neuerUmsatz;
				} else if (neuerName.equals("Robert")) {
					umsatzRobert = umsatzRobert + neuerUmsatz;
				} else if (neuerName.equals("Michael")) {
					umsatzMichael = umsatzMichael + neuerUmsatz;
				} else if (neuerName.equals("Eckard")) {
					umsatzEckard = umsatzEckard + neuerUmsatz;
				} else if (neuerName.equals("Holger")) {
					umsatzHolger = umsatzHolger + neuerUmsatz;
				} else if (neuerName.equals("Christof")) {
					umsatzChristof = umsatzChristof + neuerUmsatz;
				}
												
			}
			
			ergebnis =   "{\"Peggy\":\""  + umsatzPeggy  
					    + "\",\"Franzi\":\"" + umsatzFranzi
					    + "\",\"Oli\":\"" + umsatzOli
					    + "\",\"Marco\":\"" + umsatzMarco
					    + "\",\"Elisabeth\":\"" + umsatzElisabeth
					    + "\",\"Thorsten\":\"" + umsatzThorsten
					    + "\",\"Robert\":\"" + umsatzRobert
					    + "\",\"Michael\":\"" + umsatzMichael
					    + "\"}";
								
			return ergebnis;
	}
	
	
	// Add Methode um Zahlungen dem Array hinzuzufügen
	public void add(Zahlung zahlung) {
		zahlungen.add(zahlung);
	}
	
	// Iterator Methode
	public Iterator iterator() {
		return zahlungen.iterator();
	}
	
	public int size() {
		return zahlungen.size();
	}
	
	public Zahlung get(int position) throws Exception {
		if (zahlungen.size() >= position && position >=0 ) {
			position = position -1;
		return zahlungen.get(position);	
	} else {
		throw new Exception();
		}
	}
	
	public Zahlung delete(int position) {
		return zahlungen.remove(position);
	}
	
	// Standard Get ist wichtig, sonst können keine Zahlungen durchgereicht werden
	public ArrayList<Zahlung> getZahlungen() {
		return zahlungen;
	}
	
	// Standard Set
	public void setZahlungen(ArrayList<Zahlung> zahlungen) {
		this.zahlungen = zahlungen;
	}

	public Zahlung getZahlung(int index) {
		return (ZahlungImplService) zahlungen.get(index);
	}
}
