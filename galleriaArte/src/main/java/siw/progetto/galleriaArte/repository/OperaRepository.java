package siw.progetto.galleriaArte.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import siw.progetto.galleriaArte.model.Autore;
import siw.progetto.galleriaArte.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {

    

    List<Opera> findByAutore(Autore autore);  // ??????
        
    List<Opera> findByTitoloOrderByTitoloAsc(String titolo); 
    
    List<Opera> findByAutoreOrderByAutoreAsc(Autore autore);
    
    
}