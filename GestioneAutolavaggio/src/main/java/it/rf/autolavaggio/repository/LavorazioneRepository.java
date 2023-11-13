package it.rf.autolavaggio.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;

@Repository
public interface LavorazioneRepository extends JpaRepository<Lavorazione, Integer>{
	@Query("SELECT MAX(codice) FROM Lavorazione ")	
	Integer findMaxCodice();
	
	Optional <Lavorazione> findByCodice(Integer codiceLavorazione);
	
	Lavorazione getLavorazioneByCodice(Integer codiceLavorazione);
}
