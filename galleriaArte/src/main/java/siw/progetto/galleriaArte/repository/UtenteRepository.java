package siw.progetto.galleriaArte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import siw.progetto.galleriaArte.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {

    List<Utente> findByUsername(String username);

    List<Utente> findByNickname(String nickname);

    
}