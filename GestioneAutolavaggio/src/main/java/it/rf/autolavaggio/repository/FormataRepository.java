package it.rf.autolavaggio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.rf.autolavaggio.model.Formata;
import it.rf.autolavaggio.model.Operaio;



public interface FormataRepository extends JpaRepository<Formata, Integer>{
	
	@Query("SELECT o FROM Formata f JOIN f.operaio o WHERE f.squadra.codiceSquadra = ?1")
	List<Operaio> squadraAttiva(Integer codiceSquadra);

}

