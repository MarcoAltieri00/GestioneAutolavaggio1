package it.rf.autolavaggio.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


import it.rf.autolavaggio.model.Cliente;
import it.rf.autolavaggio.model.Lavorazione;
import it.rf.autolavaggio.model.Operaio;
import it.rf.autolavaggio.model.Possiede;
import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.model.dto.RecuperoInfoDTO;
import it.rf.autolavaggio.repository.PossiedeRepository;
import it.rf.autolavaggio.repository.VeicoloRepository;
import it.rf.autolavaggio.repository.ClienteRepository;
import it.rf.autolavaggio.repository.OperaioRepository;

@Service
public class PossiedeService {
	
	@Autowired
	private PossiedeRepository prepo;
	@Autowired
	private ClienteRepository crepo;
	@Autowired
	private VeicoloRepository vrepo;
	
	
		
	
	
	public Integer insertVeicolo(Veicolo v,String cf) {
	    Optional<Veicolo> veicolo = this.vrepo.findById(v.getnTelaio());

	    //veicolo già registrato
	    if (veicolo.isPresent()) {
	    	
	    	Optional <Possiede> posDaMod=this.prepo.trovaPossiede(v);
	    	Possiede possiedeDaMod=new Possiede();
	    	possiedeDaMod= posDaMod.get();
	    	possiedeDaMod.setPropAttuale(false);
	    	
	    	
	    	Optional<Cliente> clientesw= this.crepo.findById(cf);

	        if (clientesw.isPresent()) {
	            Cliente c = clientesw.get(); //.get mette il nuovo cliente in c
	          
	            Possiede pos = new Possiede();
	            pos.setPropAttuale(true);
	            pos.setCliente(c);
	            pos.setVeicolo(v);
	            pos.setDataRegistrazione(new Date(System.currentTimeMillis())); // Set current date

	            
	            this.prepo.save(pos);
	        }else {
	        	return 4; //nuovo cliente non è registrato
	        }
	    	
	        return 0; // cambio di proprietario del veicolo
	    } else {
	        Optional<Cliente> cliente = this.crepo.findById(cf);

	        if (cliente.isPresent()) {
	            Cliente c = cliente.get();
	          
	            Possiede pos = new Possiede();
	            pos.setPropAttuale(true);
	            pos.setCliente(c);
	            pos.setVeicolo(v);
	            pos.setDataRegistrazione(new Date(System.currentTimeMillis())); // Set current date

	            this.vrepo.save(v);
	            this.prepo.save(pos);
 // Salva l'associazione in Possiede

	            return 1; // Successo
	        } else {
	            return 2; // Cliente non trovato
	        }
	    }
	}

public ArrayList<Veicolo> ListaVeicoliCliente(Cliente c){ //questo metodo ritornerà un arraylist di veicoli
	ArrayList <Veicolo> listaVeicoli =new ArrayList <>();
	listaVeicoli= (ArrayList<Veicolo>)this.prepo.veicoliDIUnCliente(c);

	return listaVeicoli;
}
		
		
		
		
	//Tabella web
	public ArrayList<RecuperoInfoDTO> creaLista(){
		try {
		ArrayList <RecuperoInfoDTO> l=(ArrayList <RecuperoInfoDTO>) this.prepo.getVeicoloInfo();
		return l;
		
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
}







}