package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.telekom.sea7.model.implementation.KundeImpl;

@Controller
public class KundeController {
	
	
	@GetMapping("/testtest")
	public String home(Model model, 
			@RequestParam(value="kdnr", required=false, defaultValue="Kunde") 
			String kdnr) {
		
		// Testdaten erzeugen
		KundeImpl kunde1 = new KundeImpl();
		KundeImpl kunde2 = new KundeImpl();
		kunde1.setKundennummer(1234);
		kunde2.setKundennummer(2345);
		kunde1.setVorname("Oliver");
		kunde2.setVorname("Kerstin");
		
		// Variablen deklarieren
		String vorname = "";
		String nachname = "";
		
		// Login-Check
		switch (kdnr) {
		case "1234": 
			vorname = "Oliver";
			break;
		case "2345":
			vorname = "Kerstin";
			break; 
		}
		
		model.addAttribute("name", vorname);
	    return "home2";
	}
}
