package de.telekom.sea7.view;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import de.telekom.sea7.model.implementation.ZahlungE;
import de.telekom.sea7.model.implementation.ZahlungenRepository;

@RestController
public class ZahlungenController {

	@Autowired
	ZahlungenRepository zahlungen;

	/**
	 * REST API GET-Schnittstelle URL: http://localhost:8080/zahlungenDB
	 * @return Alle Zahlungen aus der DB als json
	 */
	@GetMapping("/zahlungenDB")
	@ResponseBody
	public List<ZahlungE> getAll() {
		List<ZahlungE> zahlungsListe = zahlungen.findAll();
		return zahlungsListe;
	}

	/**
	 * REST API GET-Schnittstelle 
	 * URL: http://localhost:8080/oneZahlungDB/id
	 * @return Rückgabe einer Zahlung aus der DB als json
	 */
	@GetMapping("/oneZahlungDB/{id}")
	@ResponseBody
	public Optional<ZahlungE> getOne(@PathVariable(name = "id") Long id) {
		Optional<ZahlungE> zahlung = zahlungen.findById(id);
		return zahlung;
	}
	
	
	/**
	 * REST API POST-Schnittstelle 
	 * URL: http://localhost:8080/newZahlungDB
	 */
	@PostMapping("/newZahlungDB/")
	public void addOne(@RequestBody ZahlungE zahlung) {
		zahlungen.save(zahlung);
	}
	
	/**
	 * REST API DELETE-Schnittstelle 
	 * URL: http://localhost:8080/deleteZahlungDB/id
	 */
	@DeleteMapping("/deleteZahlungDB/{id}")
	public void deleteOne(@PathVariable("id") Long id) {
		 zahlungen.deleteById(id);
		 
	}
	
	/**
	 * REST API GET-Schnittstelle URL: http://localhost:8080/zahlungenDB
	 * @return Alle Zahlungen aus der DB als json
	 */
	@GetMapping("/umsatzDB")
	@ResponseBody
	public Double umsatz() {
		return zahlungen.umsatz();
	}
	
}
