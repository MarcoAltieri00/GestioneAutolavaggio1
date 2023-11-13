package it.rf.autolavaggio.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Operaio;

@Repository
public interface OperaioRepository extends JpaRepository<Operaio, String>{

	Optional<Operaio> findByCf(String cf);

	Operaio getOperaioByCf(String cf);

}
