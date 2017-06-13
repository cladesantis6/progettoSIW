package siw.progetto.galleriaArte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import siw.progetto.galleriaArte.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {

    List<Autore> findByNome(String nome);

    List<Autore> findByCognome(String cognome);
    
    List<Autore> findByNazionalita(String nazionalita);
    
}
