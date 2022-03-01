package de.telekom.sea7.model.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahlungenRepository extends JpaRepository<ZahlungE, Long>{

	
	@Query(value = "SELECT count(id) FROM zahlunge", nativeQuery = true)
    public int anzahl();
	
	@Query(value = "SELECT sum(betrag) FROM zahlunge", nativeQuery = true)
    public Double umsatz();
	
	@Query(value = "select(SELECT sum(betrag) FROM zahlunge WHERE betrag >0) plus,(SELECT sum(betrag) FROM zahlunge WHERE betrag <0) minus from dual", nativeQuery = true)
	public Object poneUmsatz();
	
}
