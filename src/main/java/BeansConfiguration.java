import org.springframework.context.annotation.Configuration;

import de.telekom.sea7.Tier;

@Configuration
public class BeansConfiguration {
	
	public Tier getTier() {
		return new Tier();
	}

}
