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
import it.rf.autolavaggio.model.Formata;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.Squadra;
import it.rf.autolavaggio.repository.FormataRepository;
import it.rf.autolavaggio.repository.OperaioRepository;
import it.rf.autolavaggio.repository.SquadraRepository;
import it.rf.autolavaggio.repository.VeicoloRepository;

@Service
public class FormataService {
	
	@Autowired
	private FormataRepository frepo;
	@Autowired
	private OperaioRepository orepo;
	@Autowired
	private SquadraRepository srepo;
	
	
	public ArrayList<Operaio> squadraAttiva(){
		Integer a=this.srepo.findMaxCodiceSquadra();
		if(a==null) {
			
		return null;	
		}else {
			ArrayList <Operaio> listaOp=(ArrayList <Operaio>)this.frepo.squadraAttiva(a);
			
			
		return listaOp;	
		}
		
		
		
	}
	
	

	public Integer insertFormata(List<String> operaiCf ) {
		
		if (operaiCf != null && !operaiCf.isEmpty()) {
			Squadra sq= new Squadra();
			int nA=0;
			Integer a=0;
            
            List<Operaio> listaOperaio = new ArrayList<>();
            for (String cf : operaiCf) {
                
                Operaio operaio = this.orepo.getOperaioByCf(cf);  //probabile problema
                if (operaio != null) {
                	
                		a=this.srepo.findMaxCodiceSquadra();
	                	if(a==null) {
	                		a=1;
	                	}else {
	                		a++;
	                	}
                    listaOperaio.add(operaio);
                    nA++;
                }
                
                
            }
            
            if(nA>0) {
            	
            	sq.setCodiceSquadra(a);
            	sq.setnAdetti(nA);
            	this.srepo.save(sq);
            	
            }
            
            for(Operaio o : listaOperaio ) {
            	
            	 

 	            Formata form = new Formata();
 	            form.setOperaio(o);
 	            form.setSquadra(sq);
 	            form.setDataCreazioneSquadra(new Date(System.currentTimeMillis()));
 	           
 	            this.frepo.save(form);
 	            
            	
            }

            return 0;
        } else {
            
            return 1;
        }
	}


  
}