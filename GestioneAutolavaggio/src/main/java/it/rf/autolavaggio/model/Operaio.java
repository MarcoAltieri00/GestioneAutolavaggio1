package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="operaio" )
public class Operaio {
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	@Id
	@Column
	private String cf;
	
	@OneToMany(mappedBy="operaio")
	private List <Formata> formata;


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}

}
