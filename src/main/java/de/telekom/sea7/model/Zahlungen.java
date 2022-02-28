package de.telekom.sea7.model;

import java.util.Iterator;

import de.telekom.sea7.model.implementation.ZahlungImplService;

public interface Zahlungen {

	void addTestzahlungen(int anzahl);
	void add(Zahlung zahlung);
	Iterator iterator();
	int size();
	Zahlung get(int position) throws Exception;
	Zahlung getZahlung(int index);
	Zahlung delete(int position);
	double summeArrayList();
	String summeFuerChart();
}


