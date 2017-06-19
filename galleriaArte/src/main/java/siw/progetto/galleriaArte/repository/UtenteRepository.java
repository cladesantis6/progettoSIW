package siw.progetto.galleriaArte.repository;

import org.springframework.data.repository.CrudRepository;

import siw.progetto.galleriaArte.model.Utente;



public interface UtenteRepository extends CrudRepository<Utente, String> {
	
	public Utente findByUsername(String username);
	

}
