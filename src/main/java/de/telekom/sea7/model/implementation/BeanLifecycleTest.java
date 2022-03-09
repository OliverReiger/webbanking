package de.telekom.sea7.model.implementation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycleTest {
	
	// BEAN LIFECYCLE
	// -------------------------------------------------------------------------------------
	// PHASE1: Constructor wird aufgerufen
	// PHASE2: Field Properties (@Value) werden zugewiesen
	// PHASE3: Interface - ApplicationContextAware wird genutzt (wenn vorhanden)
	// -----------
	// PHASE4: Eigene init() Methode wird genutzt (aufgrund der @PostConstruct Annotation)
	// -------------------------------------------------------------------------------------
	// ..... Zwischendurch wird die Bean benutzt
	// -------------------------------------------------------------------------------------
	// PHASE5: Beim Beenden der Applikation wird die eigene destroy() Methode genutzt (aufgrund der @PreDestroy Annotation)
	
	
    /** 
     * Diese Methode wird nach der Initialisierung einer Bean ausgführt
     * Im Lifecyle ist dies: PHASE 4
     */
	@PostConstruct
    public void init() throws Exception  {
        System.out.println(
            "Bean: Hallo Welt, ich wurde gerade initialisiert mit der init() Methode");
    }
	
	
    /** 
     * Diese Methode wird nach der Beendigung der Application angewendet wenn die Bean beim aufräumen zerstört wird
     * Im Lifecyle ist dies: PHASE 5
     */
	@PreDestroy
	public void destroy() throws Exception {
		System.out.println(
				"Bean: Tschüss Welt, ich gehe jetzt in den Feierabend da du destroy() Methode aufgerufen hast.");
	}

}
