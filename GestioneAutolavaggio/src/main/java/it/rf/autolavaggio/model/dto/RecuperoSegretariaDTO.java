package it.rf.autolavaggio.model.dto;

import java.sql.Date;

public class RecuperoSegretariaDTO {
	
	private Integer numLavoro;
	private Integer codiceOrdine;
	private String targa;
	private String nomeLavorazione;
	private float prezzo;
	private Integer codiceSquadra;
	private Date dataLavorazione;
	
	
	public RecuperoSegretariaDTO( Integer numLavoro , Integer codiceOrdine, String targa, String nomeLavorazione, float prezzo,
			Integer codiceSquadra, Date dataLavorazione) {
		super();
		this.codiceOrdine = codiceOrdine;
		this.targa = targa;
		this.nomeLavorazione = nomeLavorazione;
		this.prezzo = prezzo;
		this.codiceSquadra = codiceSquadra;
		this.dataLavorazione = dataLavorazione;
		this.numLavoro=numLavoro;
	}


	public Integer getCodiceOrdine() {
		return codiceOrdine;
	}


	public void setCodiceOrdine(Integer codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}


	public String getTarga() {
		return targa;
	}


	public void setTarga(String targa) {
		this.targa = targa;
	}


	public String getNomeLavorazione() {
		return nomeLavorazione;
	}


	public void setNomeLavorazione(String nomeLavorazione) {
		this.nomeLavorazione = nomeLavorazione;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}


	public Integer getCodiceSquadra() {
		return codiceSquadra;
	}


	public void setCodiceSquadra(Integer codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}


	public Date getDataLavorazione() {
		return dataLavorazione;
	}


	public void setDataLavorazione(Date dataLavorazione) {
		this.dataLavorazione = dataLavorazione;
	}

	public Integer getNumLavoro() {
		return numLavoro;
	}
	public void setNumLavoro(Integer numLavoro) {
		this.numLavoro = numLavoro;
	}
	
}