package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BankController {
	
	// Aufruf über http://localhost:8080/test/?kontonummer=1234 gibt diese Kontonummer zurück
	@GetMapping("/test/")
	@ResponseBody
	public String getKontostand(@RequestParam(name="kontonummer") int kontonummer) {
		return String.format("{ \"kontonummer\": \"%s\" }", kontonummer);
	}
	
}
