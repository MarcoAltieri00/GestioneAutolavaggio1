package it.rf.autolavaggio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
