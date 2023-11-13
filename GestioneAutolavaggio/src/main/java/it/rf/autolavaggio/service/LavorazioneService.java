package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.repository.LavorazioneRepository;

@Service
public class LavorazioneService {
	
	@Autowired
	private LavorazioneRepository vrepo;
	
	public Integer insertLavorazione(Lavorazione l) {
		
		Integer massimo=(Integer)this.vrepo.findMaxCodice();
		if(massimo!=null) {
			massimo++;
			Lavorazione p = l;
			p.setCodice(massimo);
			this.vrepo.save(p);
			
			
			
		}
		else {
				massimo=1;
				Lavorazione p = l;
				p.setCodice(massimo);
				this.vrepo.save(p);
			
		}	return 1;
	}
	
	public ArrayList <Lavorazione> creaLista(){
		try {
		ArrayList <Lavorazione> l=(ArrayList<Lavorazione>) this.vrepo.findAll();
		return l;
		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
}
	
	public Lavorazione getByCodice(Integer codiceLavorazione) {
        
        Optional <Lavorazione> lavorazione = vrepo.findByCodice(codiceLavorazione);

        
        return lavorazione.orElse(null);
    }

}