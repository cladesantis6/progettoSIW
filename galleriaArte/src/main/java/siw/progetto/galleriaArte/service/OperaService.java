package siw.progetto.galleriaArte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import siw.progetto.galleriaArte.model.Opera;
import siw.progetto.galleriaArte.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
    private OperaRepository operaRepository; 

    public Iterable<Opera> findAll() {
        return this.operaRepository.findAll();
    }

    @Transactional
    public void add(final Opera opera) {
        this.operaRepository.save(opera);
    }

	public Opera findbyId(Long id) {
		return this.operaRepository.findOne(id);
	}

}
