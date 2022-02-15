package de.telekom.sea7.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // ein Controller ist ein Component der für eine View zuständig ist.
public class ViewImpl {
	
	@GetMapping("index.html")
	@ResponseBody
	public String getHTML() {
		return 
				"<!doctype html>"
				+ "<html>"
				+ "  <head>"
				+ "    <title>Hello from getHTML</title>"
				+ "  </head>"
				+ "  <body>"
				+ "  </body>"
				+ "/<html>";				
		
	}
	
	

}
