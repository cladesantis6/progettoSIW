package siw.progetto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAutore; 
	private String nome; 
	private String cognome; 
	private String nazionalita; 
	private Date dataNascita;
	private Date dataMorte; 
	
	@OneToMany
	private List<Opera> opere; 
	
	
	public Autore() {
		this.opere = new ArrayList<>();
	}


	public Long getIdArtista() {
		return idAutore;
	}


	public void setIdArtista(Long idAutore) {
		this.idAutore = idAutore;
	}


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


	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


	public Date getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}


	public Date getDataMorte() {
		return dataMorte;
	}


	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}


	public List<Opera> getOpere() {
		return opere;
	}


	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataMorte == null) ? 0 : dataMorte.hashCode());
		result = prime * result + ((dataNascita == null) ? 0 : dataNascita.hashCode());
		result = prime * result + ((idAutore == null) ? 0 : idAutore.hashCode());
		result = prime * result + ((nazionalita == null) ? 0 : nazionalita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((opere == null) ? 0 : opere.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autore other = (Autore) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataMorte == null) {
			if (other.dataMorte != null)
				return false;
		} else if (!dataMorte.equals(other.dataMorte))
			return false;
		if (dataNascita == null) {
			if (other.dataNascita != null)
				return false;
		} else if (!dataNascita.equals(other.dataNascita))
			return false;
		if (idAutore == null) {
			if (other.idAutore != null)
				return false;
		} else if (!idAutore.equals(other.idAutore))
			return false;
		if (nazionalita == null) {
			if (other.nazionalita != null)
				return false;
		} else if (!nazionalita.equals(other.nazionalita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (opere == null) {
			if (other.opere != null)
				return false;
		} else if (!opere.equals(other.opere))
			return false;
		return true;
	}
	
	
}

