package it.rf.autolavaggio.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import it.rf.autolavaggio.model.Cliente;
import it.rf.autolavaggio.model.Eseguita;
import it.rf.autolavaggio.model.Formata;
import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.Squadra;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.model.dto.RecuperoSegretariaDTO;
import it.rf.autolavaggio.repository.EseguitaRepository;
import it.rf.autolavaggio.repository.FormataRepository;
import it.rf.autolavaggio.repository.LavorazioneRepository;
import it.rf.autolavaggio.repository.OperaioRepository;
import it.rf.autolavaggio.repository.SquadraRepository;
import it.rf.autolavaggio.repository.VeicoloRepository;
import jakarta.transaction.Transactional;

@Service
public class EseguitaService {
	
	@Autowired
	private EseguitaRepository erepo;
	@Autowired
	private VeicoloRepository vrepo;
	@Autowired
	private SquadraRepository srepo;
	@Autowired
	private LavorazioneRepository lrepo;
	
	
	public ArrayList<RecuperoSegretariaDTO> lavorazioniAttive(){
		ArrayList <RecuperoSegretariaDTO> lavAtt=(ArrayList <RecuperoSegretariaDTO>) this.erepo.getSegretariaInfo();
			
		
		return lavAtt;
		}
		
		
	
	
	
	public Integer codMax() {
			Integer a;
			a=this.erepo.findMaxCodiceOrdine();
			if(a==null) {
				a=0;
			}
			
			
			return a;
		}
		
	@Transactional
	public void operaioEvade(Integer numLavoro) {
		Eseguita e = this.erepo.findById(numLavoro).get();
		if(e != null) {
			e.setEvaso(true);
			this.erepo.save(e);
//			this.erepo.setEvadiFalse(numLavoro);
		}
		
		
	}
	

	public Integer insertEseguita(List<Integer> listaCodiceLavorazione , String targa ) {
		
		if (listaCodiceLavorazione != null && !listaCodiceLavorazione.isEmpty() && targa != null ) {
			
			Integer cL=this.erepo.findMaxCodiceOrdine();
        	if(cL==null) {
        		cL=1;
        	}else {
        		cL++;
        	}
			
            List<Veicolo> veicolo= new ArrayList<>();
            List<Lavorazione> listaLavorazione = new ArrayList<>();
            for (int cdL : listaCodiceLavorazione ) {
                
                Lavorazione lavorazione= this.lrepo.getLavorazioneByCodice(cdL);  //probabile problema
                if (lavorazione != null) {
                    listaLavorazione.add(lavorazione);  
                }
            }
            for(Lavorazione l : listaLavorazione ) {
            	
            	 Veicolo v= this.vrepo.getVeicoloByTarga(targa);
            	Integer codSq=this.srepo.findMaxCodiceSquadra();
            	Squadra squadra=this.srepo.getSquadraByCodiceSquadra(codSq);
            	
 	            Eseguita form = new Eseguita();
 	            
 	            form.setCodiceOrdine(cL);
 	            form.setVeicolo(v);
 	            form.setLavorazione(l);
 	            form.setSquadra(squadra);
 	            form.setDataLavorazione(new Date(System.currentTimeMillis()));
 	            form.setEvaso(false);
 	            
 	            
 	            this.erepo.save(form);
 	            
            	
            }

            return 0;
        } else {
            
            return 1;
        }
	}


  
}