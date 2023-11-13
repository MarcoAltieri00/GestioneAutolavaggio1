package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente" )
public class Cliente {
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	@Id
	@Column
	private String cf;
	
	@OneToMany(mappedBy = "cliente")
	private List<Possiede> possiede	;
	
	


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
		public List<Possiede> getPossiede() {
			return possiede;
		}
		public void setPossiede(List<Possiede> possiede) {
			this.possiede = possiede;
		}

	
		
		
}
