package it.rf.autolavaggio.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="squadra")
public class Squadra {
	@Id
	@Column
	private Integer codiceSquadra;
	
	
	@Column
	private int nAdetti;
	
	@OneToMany(mappedBy="squadra")
	private List <Formata> formata;
	
	@OneToMany(mappedBy="squadra")
	private List <Eseguita> eseguita;
	
	public List<Eseguita> getEseguita() {
		return eseguita;
	}
	public void setEseguita(List<Eseguita> eseguita) {
		this.eseguita = eseguita;
	}
	
	public Integer getCodiceSquadra() {
		return codiceSquadra;
	}
	public void setCodiceSquadra(Integer codiceSquadra) {
		this.codiceSquadra = codiceSquadra;
	}
	
	public List<Formata> getFormata() {
		return formata;
	}
	public void setFormata(List<Formata> formata) {
		this.formata = formata;
	}
	
	public int getnAdetti() {
		return nAdetti;
	}
	
	public void setnAdetti(int nAdetti) {
		this.nAdetti = nAdetti;
	}
}
