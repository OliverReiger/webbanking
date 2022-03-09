package de.telekom.sea7.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea7.model.Zahlung;
import de.telekom.sea7.model.Zahlungen;
import de.telekom.sea7.model.implementation.ZahlungImplService;

// Dieser REST Controller bedient eine Array List!!!!!

@RestController
public class TransactionController {

	// Array für Testdaten erzeugen
	@Autowired
	Zahlungen zahlungen;
	
	// Methode um Testdaten ins Array zu schreiben
	@GetMapping("/createTestdata/{anzahl}")
	@ResponseBody
	public String createTestData(@PathVariable(name="anzahl") int anzahl) {
		zahlungen.addTestzahlungen(anzahl);
		return "Es wurden erfolgreich Daten erzeugt! <a href=\"/index.html\">Startseite</a>";
	}
	
	/** REST Schnittstelle zur Ausgabe aller Zahlungen aus der ArrayList als JSON
	 *  Aufruf URL: http://localhost:8080/zahlungen/ */
	@GetMapping("/zahlungen/")
	public Zahlungen getZahlungen() {
		return zahlungen;
	}
	
	/** REST Schnittstelle zur Rückgabe Info Größe ArrayList
	 *  Aufruf URL: http://localhost:8080/info/ */
	@GetMapping("/info/")
	public int getSizeZahlungen() {
		return zahlungen.size();
	}
	
	/** Schnittstelle zur Ausgabe EINER Zahlung aus der ArrayList 
	 *  Aufruf URL: http://localhost:8080/zahlung/5 */
	@GetMapping("/zahlung/{id}")
	public Zahlung getZahlung(@PathVariable(name="id") int id) throws Exception {
		return zahlungen.get(id);
	}
	
	/** Schnittstelle zum Anlegen einer neuen Zahlung 
	 *  Aufruf URL: http://localhost:8080/zahlungen/
	 */
	@PostMapping("/zahlung/")
	public String addZahlung(@RequestBody ZahlungImplService zahlung) {
		zahlungen.add(zahlung);
		return "Dein Datensatz wurde erfolgreich angelegt!";
	}
	
	/** Schnittstelle für ein Update einer neuen Zahlung 
	 *  Aufruf URL: http://localhost:8080/zahlung/5 
	 */
	@PutMapping("/zahlung/{id}")
	public Zahlung updateZahlung(@RequestBody ZahlungImplService zahlung,
								 @PathVariable("id") int id) {
		zahlungen.delete(id);
		zahlungen.add(zahlung);
		return null;
	}
	
	/** Schnittstelle zum Löschen eines Datensatzes aus der ArrayList 
	 *  Aufruf URL: http://localhost:8080/zahlung/5
	 */
	@DeleteMapping("/zahlung/{id}")
	public Zahlung deleteZahlung(@PathVariable(name="id") int id) {
		return zahlungen.delete(id);
	}
	
	
	/**
	 * Mehr zum Thema Configuration Properties
	 * URL: https://www.dev-insider.de/spring-anwendungen-per-properties-konfigurieren-a-1013023/
	 * Methode gibt den Value aus dem Key/Value Paar aus der application.properties
	 
	@Value("${greeting}")
	private String greeting;
	@GetMapping("/	/")
	public String getBegruessung() {
		return greeting;
	}
	*/
	
	
	/** REST Schnittstelle zur Rückgabe Info Summe ArrayList
	 *  Aufruf URL: http://localhost:8080/info/ */
	@GetMapping("/infoUmsatz/")
	public double getUmsatzZahlungen() {
		return zahlungen.summeArrayList();
		}
	
	/** REST Schnittstelle zur Rückgabe Info Größe ArrayList
	 *  Aufruf URL: http://localhost:8080/infoChart */
	@GetMapping("/infoChart/")
	public String getChartData() {
		return zahlungen.summeFuerChart();
		}
	
}
