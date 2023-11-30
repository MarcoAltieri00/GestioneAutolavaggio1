package it.rf.autolavaggio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="eseguita")
public class Eseguita {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
	private Integer numLavoro;
	
	@Column
	private int codiceOrdine;
	@Column
	private Date dataLavorazione;
	@Column
	private boolean evaso;
	
	@ManyToOne
	private Lavorazione lavorazione;
	
	@ManyToOne
	private Veicolo veicolo;
	
	@ManyToOne
	private Squadra squadra;
	
	
	public int getCodiceOrdine() {
		return codiceOrdine;
	}
	public void setCodiceOrdine(int codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}
	public Date getDataLavorazione() {
		return dataLavorazione;
	}
	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}
	public Lavorazione getLavorazione() {
		return lavorazione;
	}
	public void setEvaso(boolean evaso) {
		this.evaso = evaso;
	}
	public Integer getNumLavoro() {
		return numLavoro;
	}
	public void setLavorazione(Lavorazione lavorazione) {
		this.lavorazione = lavorazione;
	}
	public Squadra getSquadra() {
		return squadra;
	}
	public void setNumLavoro(Integer numLavoro) {
		this.numLavoro = numLavoro;
	}
	public Veicolo getVeicolo() {
		return veicolo;
	}
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
	
	
	
	
	
}
