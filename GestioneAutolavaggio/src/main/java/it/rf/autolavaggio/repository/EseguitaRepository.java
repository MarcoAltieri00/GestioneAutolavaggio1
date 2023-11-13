package it.rf.autolavaggio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import it.rf.autolavaggio.model.Eseguita;

import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.dto.RecuperoInfoDTO;
import it.rf.autolavaggio.model.dto.RecuperoSegretariaDTO;



public interface EseguitaRepository extends JpaRepository<Eseguita, Integer>{
	@Query("SELECT new it.rf.autolavaggio.model.dto.RecuperoSegretariaDTO(e.numLavoro,e.codiceOrdine, v.targa, l.nome, l.costo, s.codiceSquadra, e.dataLavorazione) FROM Eseguita e JOIN e.squadra s JOIN e.veicolo v JOIN e.lavorazione l WHERE e.evaso = false ORDER BY e.codiceOrdine")
	List<RecuperoSegretariaDTO> getSegretariaInfo();

	
	@Query("SELECT MAX(e.codiceOrdine) FROM Eseguita e ")	
	Integer findMaxCodiceOrdine();
	
	
	@Modifying
	@Query("UPDATE Eseguita e SET e.evaso=true WHERE e.numLavoro= ?1 ")
	void setEvadiFalse(Integer numLavoro);

}
