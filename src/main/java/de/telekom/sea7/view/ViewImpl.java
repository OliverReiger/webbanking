package de.telekom.sea7.view;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import de.telekom.sea7.model.implementation.ZahlungImplService;
import de.telekom.sea7.model.implementation.ZahlungenImplService;


@Controller // Annotation um zu singalisieren das dies unsere View (View-Controller) ist.
public class ViewImpl {
	
	//Instanziierung einer Zahlungsreferenz
	@Autowired
	ZahlungImplService dummyZahlung1;
	@Autowired
	ZahlungenImplService zahlungen;
	
	/** Methode wird über URL aufgerufen und erstellt ein Array mit einer
	 *  beliebigen (übergebenen Anzahl) von Beispielzahlungen
	 *  URL Aufruf: http://localhost:8080/createTestdata/1
	 
	@GetMapping("/createTestdata/{anzahl}")
	@ResponseBody
	public String createTestData(@PathVariable(name="anzahl") int anzahl) {
		zahlungen.addTestzahlungen(anzahl);
		return "Es wurden erfolgreich Daten erzeugt! <a href=\"/index.html\">Startseite</a>";
	}
	
	*/
	// Schnittstellenmethode die eine JSON über http://localhost:8080/zahlung.json zurückgibt
	@GetMapping("/zahlung.json")
	@ResponseBody
	public String getSingleJSON() {

		//Testwerte für Zahlung setzen
		dummyZahlung1.setEmpfaenger("Tester 1");
		dummyZahlung1.setEmpfaengerIBAN("DEIBANTEST1");
		dummyZahlung1.setEmpfaengerBIC("BICTEST1");
		dummyZahlung1.setBetrag(111.11);
		dummyZahlung1.setWaehrung("Euro");
		dummyZahlung1.setVerwendungszweck("Test Zweck 1");
		
		// Return der Einzelzahlung im JSON-Format
		return 
			  "{"
			 +" \"empfaenger\": " 	   + "\"" + dummyZahlung1.getEmpfaenger()		+ "\"" + ","
			 +" \"iban\": "       	   + "\"" + dummyZahlung1.getEmpfaengerIBAN()	+ "\"" + ","
			 +" \"bic\": "        	   + "\"" + dummyZahlung1.getEmpfaengerBIC()	+ "\"" + ","
			 +" \"betrag\":"      	   + "\"" + dummyZahlung1.getBetrag()			+ "\"" + ","
			 +" \"waehrung\":"    	   + "\"" + dummyZahlung1.getWaehrung()			+ "\"" + ","
			 +" \"verwendungszweck\":" + "\"" + dummyZahlung1.getVerwendungszweck()	+ "\""
			 +"}";
	}
	
	
	
	//@GetMapping("/zahlungen.json")
	@RequestMapping(value="/zahlungen.json", produces="application/json", method=RequestMethod.GET)
	@ResponseBody
	public String getZahlungen() {
				
		// Deklaration Varible zur Erstellung des JSON Strings
		String ergebnis = "{" ; 
		
		// Initialisierung der Iterator-Schnittstelle von Java mit dem Parameter
		// welche Objekte durchlaufen werden sollen (ZahlungImplService-Objekte)
		// und der Zuweisung des Arrays das durchlaufen werden soll.
		Iterator<ZahlungImplService> tempZahlungIterator = zahlungen.iterator();
		
		int id = 1; // Zähler um die Ausgaben in der JSON zu Nummerieren
		
		// Lieber Iterator, solange du noch ein Objekt im Array findest (hasNext noch true ist)
		// solange durchlaufe die Schleife, wenn kein nächstes Objekt gefunden wird (hasNext false ist)
		// brauchst du die Schleife nicht mehr ausführen
		while (tempZahlungIterator.hasNext()) {
			
			// Zwischenspeicherung einzelner Zahlung Objekte aus der Iteration
			ZahlungImplService tempZahlung = tempZahlungIterator.next(); 
			
			// Entpacken der Objekte
			String empfaenger = tempZahlung.getEmpfaenger();
			String iban = tempZahlung.getEmpfaengerIBAN();
			String bic = tempZahlung.getEmpfaengerBIC();
			Double betrag = tempZahlung.getBetrag();
			String waehrung = tempZahlung.getWaehrung();
			String verwendungszweck = tempZahlung.getVerwendungszweck();
			
			
			String tempIteration = 
				"\""+ id +"\":{" 
				+ " \"Empfaenger\": " + "\""+ empfaenger + "\"," 
				+ " \"Iban\": " + "\"" + iban + "\","
				+ " \"Bic\": " + "\"" + bic + "\","
				+ " \"Betrag\": " + "\"" + betrag + "\"," 
				+ " \"Waehrung\": " + "\""+ waehrung + "\","
				+ " \"Verwendungszweck\": " + "\"" + verwendungszweck + "\"" 
				+ " }";
			
			// Anfügen der ausgepackten Iterationsergebnisse an den JSON String
			ergebnis = ergebnis + tempIteration;	
			
			// Bedingung, damit nach dem letzten Eintrag kein Komma im JSON String gebaut wird.
			if (id <= zahlungen.size()-1) {
				ergebnis = ergebnis + ",";
			}
			
			// Hochzählen des Zählers für die Durchnummerierung der Ergebnisse
			id++;
		}
		// Endklammer im JSON String nach Beendigung der Durchläufe anfügen
		ergebnis = ergebnis + "}";
		
		// Ergebnis zurückgeben
		return ergebnis;
	}
}
