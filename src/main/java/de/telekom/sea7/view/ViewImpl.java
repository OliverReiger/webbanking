package de.telekom.sea7.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea7.implementation.ZahlungImplService;

@Controller // Annotation um zu singalisieren das dies unsere View (View-Controller) ist.
public class ViewImpl {
	
	//Instanziierung einer Zahlungsreferenz mit Beispieldaten
	@Autowired
	ZahlungImplService dummyZahlung;
	
	
	// Schnittstellenmethode die eine JSON zurückgibt
	@GetMapping("zahlung.json")
	@ResponseBody
	public String getJSON() {

		return 
			  "{"
			 //+" 'zahlung': {"
			 +" \"empfaenger\": " 	   + "\"" + dummyZahlung.getEmpfaenger()		+ "\"" + ","
			 +" \"iban\": "       	   + "\"" + dummyZahlung.getEmpfaengerIBAN()	+ "\"" + ","
			 +" \"bic\": "        	   + "\"" + dummyZahlung.getEmpfaengerBIC()	    + "\"" + ","
			 +" \"betrag\":"      	   + "\"" + dummyZahlung.getBetrag()			+ "\"" + ","
			 +" \"waehrung\":"    	   + "\"" + dummyZahlung.getWaehrung()			+ "\"" + ","
			 +" \"verwendungszweck\":" + "\"" + dummyZahlung.getVerwendungszweck()	+ "\""
			 //+"},"
			 +"}";
	}
	
}
