package de.telekom.sea7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebBankingApplication {
	
	@Autowired
	Tier tier;
	
	Tier tier2 = new Tier();
	

	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebBankingApplication.class, args);

	}
}
