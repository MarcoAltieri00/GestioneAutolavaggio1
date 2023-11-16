package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.repository.VeicoloRepository;

@Service
public class VeicoloService {
	
	@Autowired
	private VeicoloRepository vrepo;

	
//	public Integer insertVeicolo(Veicolo v) {
//		Optional <Veicolo> veicolo= this.vrepo.findById(v.getnTelaio());
//		if(veicolo.isPresent()) {
//			return 0;
//		}
//		else {
//			v.setPropAttuale(true);
//			this.vrepo.save(v);	
//			return 1;
//		}	
//	}
	
//	public ArrayList <Veicolo> creaLista(){
//		try {
//		ArrayList <Veicolo> l=(ArrayList<Veicolo>) this.vrepo.lista();
//		return l;
//		
//		}catch(EmptyResultDataAccessException e) {
//			return null;
//		}
//}
	public Veicolo getVeicoloByTarga(String targa) {
        
        Optional<Veicolo> veicolo = vrepo.findByTarga(targa);

        
        return veicolo.orElse(null);
    }

  
}