package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@ResponseBody --> wird aufgrund von Thymeleaf nicht mehr benötigt
public class ControllerThymeleaf {
	
	/*
	// Aufruf: http://localhost:8080/?name=Oliver
	@GetMapping("/")
	public String home(Model model, 
			@RequestParam(value="name",
            required=false,
            defaultValue="World") 
			String name) {
		
	    // String name = "Oliver";
	    
		model.addAttribute("name", name);
		
	    return "home2";
	}
	*/
	
}
