package it.rf.autolavaggio.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.dto.RecuperoInfoDTO;


	
	
	@Repository
	public interface PossiedeRepository extends JpaRepository<Possiede, Integer> {
	    // ...

	    @Query("SELECT new it.rf.autolavaggio.model.dto.RecuperoInfoDTO(p.cliente.cf, p.veicolo.targa, p.veicolo.nTelaio) FROM Possiede p")
	    List<RecuperoInfoDTO> getVeicoloInfo();
	}