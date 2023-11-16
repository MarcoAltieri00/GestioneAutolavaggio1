package it.rf.autolavaggio.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.rf.autolavaggio.model.Cliente;
import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.model.dto.RecuperoInfoDTO;


	
	
	@Repository
	public interface PossiedeRepository extends JpaRepository<Possiede, Integer> {
	    // ...

	    @Query("SELECT new it.rf.autolavaggio.model.dto.RecuperoInfoDTO(p.cliente.cf, p.veicolo.targa, p.veicolo.nTelaio) FROM Possiede p where propAttuale=true")
	    List<RecuperoInfoDTO> getVeicoloInfo();
	    
	    @Query( "Select Veicolo v from Possiede p where propAttuale=true")
		List<Veicolo> lista();
	    
	    
	    @Query("SELECT p FROM Possiede p WHERE p.veicolo = ?1 AND p.propAttuale = true")
	    Optional<Possiede> trovaPossiede(Veicolo v);
		
	    //calcolo i veicoli del cliente che ha avuto
	    @Query("SELECT p.veicolo FROM Possiede p WHERE p.cliente = ?1")
	    List<Veicolo> veicoliDIUnCliente(Cliente c);
	    
	    
		
	}