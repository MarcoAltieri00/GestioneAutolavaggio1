package it.rf.autolavaggio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.autolavaggio.model.Veicolo;
import it.rf.autolavaggio.service.GenericService;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping(path = "/veicolo")
public class VeicoloRestController {
	
	@Autowired
	private GenericService service; 
	
	
	@GetMapping(value = "/get/{id}")
	public Veicolo getVeicoloById(@PathVariable String id) {
		Veicolo v = this.service.getVeicolo(id);
		return v;
	}
	
	
	@GetMapping(path = "/get")
	public List<Veicolo> getVeicolo(@PathParam(value = "id") String id) {
		List<Veicolo> v = this.service.getAllVeicolo(id);
		return v;
	}
	
	
	@PutMapping(value = "/insert")
	public Veicolo putMethodName(@RequestBody Veicolo entity) {
		this.service.insertVeicolo(entity);
		return entity;
	}

	

}