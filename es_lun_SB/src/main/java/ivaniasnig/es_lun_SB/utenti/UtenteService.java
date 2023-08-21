package ivaniasnig.es_lun_SB.utenti;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import ivaniasnig.es_lun_SB.exceptions.BadRequestException;
import ivaniasnig.es_lun_SB.exceptions.NotFoundException;

@Repository
public class UtenteService {
	
	@Autowired
	private UtenteRepository utentiRepo;
	
	public Utente save(Utente utente) {
		
	    if (utente.getPassword().length() < 6) {
	        throw new BadRequestException("La password deve contenere almeno 6 caratteri");
	    }
		
		utentiRepo.findByEmail(utente.getEmail()).ifPresent(user -> {
			throw new BadRequestException("email già in uso");
		});
		
		return utentiRepo.save(utente);
	}
	
	public Page<Utente> find(int page, int size, String sort){
		Pageable pageable =PageRequest.of(page, size, Sort.by(sort));
		
		return utentiRepo.findAll(pageable);
	}
	
	public Utente findById(UUID id) throws NotFoundException {
		return utentiRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public Utente findByIdAndUpdate(UUID id, Utente utente) throws NotFoundException {

		Utente found = this.findById(id);
		found.setCognome(utente.getCognome());
		found.setEmail(utente.getEmail());
		found.setNome(utente.getNome());
		found.setPassword(utente.getPassword());
		
		return utentiRepo.save(found);
	}
	
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Utente found = this.findById(id);
		utentiRepo.delete(found);
	}
	
	public Utente findByEmail(String email) {
		return utentiRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("Utente non trovato"));
		
	}
}
