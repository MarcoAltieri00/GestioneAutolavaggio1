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
@Table(name="formata")
public class Formata {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer num;
	
	@Column
	private Date DataCreazioneSquadra;

	@ManyToOne
	private Operaio operaio;
	
	@ManyToOne
	private Squadra squadra;
	
	
	public Date getDataCreazioneSquadra() {
		return DataCreazioneSquadra;
	}
	
	public void setDataCreazioneSquadra(Date dataCreazioneSquadra) {
		DataCreazioneSquadra = dataCreazioneSquadra;
	}
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	public Operaio getOperaio() {
		return operaio;
	}
	
	public void setOperaio(Operaio operaio) {
		this.operaio = operaio;
	}
	
	public Squadra getSquadra() {
		return squadra;
	}
	
	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}


	
}
