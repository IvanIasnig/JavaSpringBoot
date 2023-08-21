package ivaniasnig.es_lun_SB.dispositivi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import ivaniasnig.es_lun_SB.exceptions.BadRequestException;
import ivaniasnig.es_lun_SB.exceptions.NotFoundException;
import ivaniasnig.es_lun_SB.utenti.Utente;
import ivaniasnig.es_lun_SB.utenti.UtenteService;

@Repository
public class DispositiviService {
	
	@Autowired
	private DispositiviRepo dispositiviRepo;
	
	@Autowired
	private UtenteService utentiService; //prova fix 403
	
	public Dispositivi save(Dispositivi dispositivo, UUID idUtente) {
		
	    if (dispositivo.getUtente().getId() != null && dispositivo.getDispositiviStato() != DispositiviStato.DISPONIBILE) {
	        throw new BadRequestException("Dispositivo non disponibile, non puoi assegnarlo ad un utente!");
	    }
		if(dispositivo.getUtente().getId() == null) {
			dispositivo.setUtente(null);
			return dispositiviRepo.save(dispositivo);
		}
		Utente utente = utentiService.findById(idUtente); //prova fix 403
		dispositivo.setUtente(utente); //prova fix 403
		return dispositiviRepo.save(dispositivo);
	}
	
	public Page<Dispositivi> find (int page, int size, String sort){
		Pageable pageable =PageRequest.of(page, size, Sort.by(sort));
		
		return dispositiviRepo.findAll(pageable);
	}
	
	public Dispositivi findById(UUID id) throws NotFoundException {
		return dispositiviRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
	}
	
	public Dispositivi findByIdAndUpdate(UUID id, Dispositivi dispositivo) throws NotFoundException {

		Dispositivi found = this.findById(id);
		found.setDispositiviStato(dispositivo.getDispositiviStato());
		found.setDispositiviTipo(dispositivo.getDispositiviTipo());
		found.setUtente(dispositivo.getUtente());
		
		return dispositiviRepo.save(found);
	}
	
	public void findByIdAndDelete(UUID id) throws NotFoundException {
		Dispositivi found = this.findById(id);
		dispositiviRepo.delete(found);
	}
}
