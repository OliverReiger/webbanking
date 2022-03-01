package de.telekom.sea7.model.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahlungenRepository extends JpaRepository<ZahlungE, Long>{

	
	@Query(value = "SELECT sum(betrag) FROM zahlunge", nativeQuery = true)
    public Double umsatz();
    

	
}
