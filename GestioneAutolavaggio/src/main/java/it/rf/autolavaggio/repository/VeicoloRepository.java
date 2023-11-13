package it.rf.autolavaggio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Veicolo;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, String>{

	Optional<Veicolo> findByTarga(String targa);

	Veicolo getVeicoloByTarga(String targa);
}
