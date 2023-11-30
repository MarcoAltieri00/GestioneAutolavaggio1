package it.rf.autolavaggio.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//@GeneratedValue(strategy = GenerationType.IDENTITY) (questo è l'auto increment)
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "veicolo")
public class Veicolo {
	
	@Id
	@Column 
	private String nTelaio;
	@Column
	private String targa;
	
	
	
	@OneToMany(mappedBy = "veicolo")
	@JsonIgnore
	private List<Possiede> possiede;
	
	@OneToMany(mappedBy="veicolo")
	@JsonIgnore
	private List <Eseguita> eseguita;
	
	public List<Eseguita> getEseguita() {
		return eseguita;
	}
	public void setEseguita(List<Eseguita> eseguita) {
		this.eseguita = eseguita;
	}
	
	
	public String getnTelaio() {
		return nTelaio;
	}
	public void setnTelaio(String nTelaio) {
		this.nTelaio = nTelaio;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public List<Possiede> getPossiede() {
		return possiede;
	}
	public void setPossiede(List<Possiede> possiede) {
		this.possiede = possiede;
	}


}
