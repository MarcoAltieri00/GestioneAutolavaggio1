package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


import it.rf.autolavaggio.model.Operaio;

import it.rf.autolavaggio.repository.OperaioRepository;

@Service
public class OperaioService {
	
	@Autowired
	private OperaioRepository vrepo;
	
	
		
		public Integer insertOperaio(Operaio o) {
			Optional <Operaio> operaio= this.vrepo.findById(o.getCf());
			if(operaio.isPresent()) {
				return 0;
			}
			else {
				this.vrepo.save(o);	
				return 1;
			}	
		}
	
	
	public ArrayList <Operaio> creaLista(){
		try {
		ArrayList <Operaio> l=(ArrayList<Operaio>) this.vrepo.findAll();
		return l;
		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
}
	
	

	   

	    public Operaio getOperaioByCf(String cf) {
	        
	        Optional<Operaio> operaio = vrepo.findByCf(cf);

	        
	        return operaio.orElse(null);
	    }
	}

