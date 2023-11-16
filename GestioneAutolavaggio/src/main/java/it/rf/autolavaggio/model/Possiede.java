package it.rf.autolavaggio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="possiede")
public class Possiede {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codice;

	
	@Column
	private Date dataRegistrazione;
	
		
	@ManyToOne 
	private Veicolo veicolo;
	
	
	@ManyToOne
	private Cliente cliente;

	@Column
	private boolean propAttuale;
	
	public void setPropAttuale(boolean propAttuale) {
		this.propAttuale = propAttuale;
	}
	public boolean isPropAttuale() {
		return propAttuale;
	}

	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public int getCodice() {
		return codice;
	}
	
	public void setCodice(int codice) {
		this.codice = codice;
	}
	
	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}
	
	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	public Veicolo getVeicolo() {
		return veicolo;
	}
	
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
}
