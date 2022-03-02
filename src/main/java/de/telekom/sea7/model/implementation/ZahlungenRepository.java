package de.telekom.sea7.model.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahlungenRepository extends JpaRepository<ZahlungE, Long>{

	// Ermittlung der Anzahl der Einträge in DB
	@Query(value = "SELECT count(id) FROM zahlunge", nativeQuery = true)
    public int anzahl();
	
	// Ermittlung aller Umsätze aus DB
	@Query(value = "SELECT sum(betrag) FROM zahlunge", nativeQuery = true)
    public Double umsatz();
	
	// Ermittlung aller positiven und negativen Beträge aus der DB
	@Query(value = "select(SELECT sum(betrag) FROM zahlunge WHERE betrag >0) plus,(SELECT sum(betrag) FROM zahlunge WHERE betrag <0) minus from dual", nativeQuery = true)
	public Object poneUmsatz();
	
	// Ermittlung von Umsätzen diverser Katekorien aus der DB
	@Query(value = "SELECT sum(betrag) FROM zahlunge WHERE kategorie = :kategorie", nativeQuery = true)
	public Double umsatzKategorie(String kategorie);
	
	
	
}
