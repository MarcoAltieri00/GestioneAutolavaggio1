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
			
			a++;
			return a;
		}
		
	@Transactional
	public void operaioEvade( Integer numLavoro) {
		
		
		this.erepo.setEvadiFalse(numLavoro);
		
	}
	
	
	
	//tutte le operazioni eseguite su un singolo veicolo
	public ArrayList <Eseguita> LavorazioniEseguiteSuUnVeicolo(ArrayList <Veicolo> lista, Cliente c){
		
		ArrayList <Eseguita> listaEs=new ArrayList <Eseguita> ();
		  //tutte le lavorazioni eseguite su un veicolo di 1 cliente
		ArrayList <Eseguita> listaF=new ArrayList <Eseguita> ();
		if(!lista.isEmpty()) {
		for(Veicolo v: lista) {
			
		//mi prende tutte le lavorazioni di 1 veicolo,gli passo 1 cliente e 1 veicolo,
	    //operazioni fatte su quel veicolo e pagate da quel cliente			
		listaEs=(ArrayList <Eseguita>)this.erepo.lavorazioniCliente(v,c);
		for(Eseguita e: listaEs) {
			
			listaF.add(e);
			
		}
		
		}
		
		
		return listaF;
		}
		else {
			return null;
		}
	}
	
	public Float calcoloSpese(ArrayList <Eseguita> lista) {
	    Float spese = 0f;

	    if (lista != null) {
	        for (Eseguita e : lista) {
	            Lavorazione lav = e.getLavorazione();
	            Float costo = lav.getCosto();
	            spese = spese + costo;
	        }
	    }

	    return spese;
	}

	public Integer insertEseguita(List<Integer> listaCodiceLavorazione , String targa ) {
		Optional<Veicolo> veicolo= this.vrepo.getVeicoloByTarga(targa);
   	 if(veicolo.isPresent()){
   		 Veicolo v=veicolo.get();
		if (listaCodiceLavorazione != null && !listaCodiceLavorazione.isEmpty() ) {
			
			Integer cL=this.erepo.findMaxCodiceOrdine();
        	if(cL==null) {
        		cL=1;
        	}else {
        		cL++;
        	}
			
            
            List<Lavorazione> listaLavorazione = new ArrayList<>();
            for (int cdL : listaCodiceLavorazione ) {
                
                Lavorazione lavorazione= this.lrepo.getLavorazioneByCodice(cdL);  
                if (lavorazione != null) {
                    listaLavorazione.add(lavorazione);  
                }
            }
            for(Lavorazione l : listaLavorazione ) {
            	
            	 
            	 
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
		}else {
			return 1;
		}
        } else {
            
            return 2;
        }
	}

}