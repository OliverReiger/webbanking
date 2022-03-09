package de.telekom.sea7.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.model.implementation.ZahlungImplService;
import de.telekom.sea7.model.implementation.ZahlungenImplService;

@Controller
public class BankController {
	
	//Instanziierung einer Zahlungsreferenz
	@Autowired
	ZahlungImplService dummyZahlung1;
	@Autowired
	ZahlungImplService dummyZahlung2;
	@Autowired
	ZahlungImplService dummyZahlung3;
	@Autowired
	ZahlungenImplService zahlungen;
	
	// Aufruf über http://localhost:8080/test/?kontonummer=1234 gibt diese Kontonummer zurück
	@GetMapping("/test/")
	@ResponseBody
	public String getKontostand(@RequestParam(name="kontonummer") int kontonummer) {
		return String.format("{ \"kontonummer\": \"%s\" }", kontonummer);
	}
	
	
	// http://localhost:8080/einzelzahlung/1
	
	//                          Platzhalter   RequestParameter
	//           /einzelzahlung/ 1                  ?id=1
	
	@GetMapping("/einzelzahlung/{id}")              //?id=1
	@ResponseBody
	public String getEinzelzahlung(@PathVariable(name="id") int id) throws Exception {

		//Testwerte für Zahlung setzen
		dummyZahlung1.setEmpfaenger("Tester 1");
		dummyZahlung1.setEmpfaengerIBAN("DEIBANTEST1");
		dummyZahlung1.setEmpfaengerBIC("BICTEST1");
		dummyZahlung1.setBetrag(111.11);
		dummyZahlung1.setWaehrung("Euro");
		dummyZahlung1.setVerwendungszweck("Test Zweck 1");
		
		dummyZahlung2.setEmpfaenger("Tester 2");
		dummyZahlung2.setEmpfaengerIBAN("DEIBANTEST2");
		dummyZahlung2.setEmpfaengerBIC("BICTEST2");
		dummyZahlung2.setBetrag(222.22);
		dummyZahlung2.setWaehrung("Euro");
		dummyZahlung2.setVerwendungszweck("Test Zweck 2");
		
		dummyZahlung3.setEmpfaenger("Tester 3");
		dummyZahlung3.setEmpfaengerIBAN("DEIBANTEST3");
		dummyZahlung3.setEmpfaengerBIC("BICTEST3");
		dummyZahlung3.setBetrag(333.33);
		dummyZahlung3.setWaehrung("Euro");
		dummyZahlung3.setVerwendungszweck("Test Zweck 3");
		
		zahlungen.add(dummyZahlung1);
		zahlungen.add(dummyZahlung2);
		zahlungen.add(dummyZahlung3);
		
		//ZahlungImplService resultObject = zahlungen.get(id);
		
		
		return  ("{"
				 +" \"empfaenger\": " 	   + "\"" + zahlungen.get(id).getEmpfaenger()		+ "\"" + ","
				 +" \"iban\": "       	   + "\"" + zahlungen.get(id).getEmpfaengerIBAN()	+ "\"" + ","
				 +" \"bic\": "        	   + "\"" + zahlungen.get(id).getEmpfaengerBIC()	+ "\"" + ","
				 +" \"betrag\":"      	   + "\"" + zahlungen.get(id).getBetrag()			+ "\"" + ","
				 +" \"waehrung\":"    	   + "\"" + zahlungen.get(id).getWaehrung()			+ "\"" + ","
				 +" \"verwendungszweck\":" + "\"" + zahlungen.get(id).getVerwendungszweck()	+ "\""
				 +"}");
		
		/*
		return String.format(
				"{ \"empfaenger\": \"%s\", \"iban\": \"%s\" }",
				id);*/
		
	}
	
	/**
	@Controller
	public class BankController {

		
		 * Protokoll:         http (sonst https)
		 * ://
		 * Host:              localhost
		 * Pfad (Path):       /search/{kundennummer}  
		 * ?
		 * Request Parameter: kontonummer=1234567&datum=heute
		 * @return
		 
		
		//                    Platzhalter!
		@GetMapping("/search/{kundennummer}")
		@ResponseBody // das ist ja die Antwort!!!!
		public String getKontostand(
				@PathVariable("kundennummer") String kundennummer,
				
				@RequestParam("kontonummer") int kontonummer,
				@RequestParam("datum") String datum
				
				 ) {
			
			return String.format(
				"{ \"kundennummer\": \"%s\", \"kontonummer\": \"%s\" }",
				kundennummer,
				kontonummer);
		}
		
	}
	*/
	
}
