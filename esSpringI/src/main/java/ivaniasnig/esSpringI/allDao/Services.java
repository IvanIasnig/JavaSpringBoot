package ivaniasnig.esSpringI.allDao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esSpringI.classi.Edificio;
import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.classi.Utente;
import ivaniasnig.esSpringI.enums.TipoPostazione;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Services implements IDao {
	@Autowired
	private UtentiRepository utentiRepository;
	
	@Autowired
	private EdificiRepository edificiRepository;
	
	@Autowired
	private PostazioniRepository postazioniRepository;
	
	@Autowired
	private PrenotazioniRepository prenotazioniRepository;

	public void save(Utente utente) {
		utentiRepository.save(utente);
		log.info(utente.getNomeCompleto() + " salvato!");
	}
	
	public void save(Postazione postazione) {
		postazioniRepository.save(postazione);
		log.info(postazione + " salvato!");
	}

	public void save(Edificio edificio) {
		edificiRepository.save(edificio);
		log.info(edificio + " salvato!");
	}
	
	public void save(Prenotazione prenotazione) {
		prenotazioniRepository.save(prenotazione);
		log.info(prenotazione + " salvato!");
	}

	public List<Utente> findAll() {
		return utentiRepository.findAll();
	}

	public Utente findById(String username) throws RuntimeException {
		return utentiRepository.findById(username).orElseThrow(() -> new RuntimeException(username));
	}

	public void findByIdAndUpdate(String username, Utente utente) throws RuntimeException {
		Utente found = this.findById(username); 

		found.setUsername(utente.getUsername());
		found.setNomeCompleto(utente.getNomeCompleto());
		found.setMail(utente.getMail());

		utentiRepository.save(found);
	}

	public void findByIdAndDelete(String username) throws RuntimeException {
		Utente found = this.findById(username);
		utentiRepository.delete(found);
	}

	public long count() {
		return utentiRepository.count();
	}
	
	public boolean postazioneLibera(Postazione postazione, LocalDate date) {
	    return prenotazioniRepository.existsByPostazioneAndDataPrenotazione(postazione, date);
	}

	public boolean puoPrenotare(Utente utente, LocalDate date) {
	    return prenotazioniRepository.existsByUtenteAndDataPrenotazione(utente, date);
	}
	
	public void findPostazione(TipoPostazione tipo, String citta) {
        List<Postazione> postazione = postazioniRepository.findByTipoAndEdificio_Citta(tipo, citta);
        if (postazione != null) {
            for (Postazione postazioni : postazione) {
                log.info("Postazione trovata: " + postazioni.getCu() + " a: " + postazioni.getEdificio().getCitta());
            }
        } else {
            log.info("Postazione non trovata");
        }
    }


}

