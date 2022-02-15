package de.telekom.sea7;

import org.springframework.stereotype.Component;

@Component
public class Tier {

	public Tier createTier() throws Exception {
		//List<String> result = Files.readAllLines((new File("WelchesTier.csv")));
		String klasse = "de.telekom.sea7.Hund";
		Class<?> myclass = Class.forName(klasse);
		return (Tier) myclass.getDeclaredConstructor().newInstance();
	}
	
}
