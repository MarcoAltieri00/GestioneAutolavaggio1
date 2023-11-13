package it.rf.autolavaggio.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


import it.rf.autolavaggio.model.Cliente;
import it.rf.autolavaggio.repository.ClienteRepository;
import it.rf.autolavaggio.repository.OperaioRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository vrepo;
	
	
		
		public Integer insertCliente(Cliente c) {
			Optional <Cliente> cliente= this.vrepo.findById(c.getCf());
			if(cliente.isPresent()) {
				return 0;
			}
			else {
				this.vrepo.save(c);	
				return 1;
			}	
		}
	
	
	public ArrayList <Cliente> creaLista(){
		try {
		ArrayList <Cliente> l=(ArrayList<Cliente>) this.vrepo.findAll();
		return l;
		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
}

}