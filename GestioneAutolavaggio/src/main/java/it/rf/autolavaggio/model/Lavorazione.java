package it.rf.autolavaggio.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="lavorazione" )
public class Lavorazione {
		@Id
		@Column
		private Integer codice	;
		
		@Column
		private String nome;
		
		@Column
		private float costo;
		
		@OneToMany(mappedBy="lavorazione")
		private List <Eseguita> eseguita;
		
		public List<Eseguita> getEseguita() {
			return eseguita;
		}
		public void setEseguita(List<Eseguita> eseguita) {
			this.eseguita = eseguita;
		}
		
		public int getCodice() {
			return codice;
		}
		public void setCodice(int codice) {
			this.codice = codice;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public float getCosto() {
			return costo;
		}
		public void setCosto(float costo) {
			this.costo = costo;
		}
		
}
