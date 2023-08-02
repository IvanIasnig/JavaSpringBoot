package ivaniasnig.esMercoledi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.classi.Prenotazione;
import ivaniasnig.esMercoledi.classi.PrenotazionePayload;
import ivaniasnig.esMercoledi.classi.Utente;
import ivaniasnig.esMercoledi.repository.PrenotazioneRepository;


@Service
public class PrenotazioneService {
	//List<Prenotazione> listaPrenotazioni = new ArrayList<>();
	@Autowired
	private PrenotazioneRepository prenotazioneRepo;
	
	@Autowired
	PostazioneService postazioneService;
	
	@Autowired
	UtenteService utenteService;
	
	public Prenotazione save(LocalDate dataPrenotazione, int postazioneId, String username) throws Exception {

	    if (!dataPrenotazione.isAfter(LocalDate.now().plusDays(1))) {
	        throw new Exception("La prenotazione deve essere effettuata almeno 2 giorni prima della data desiderata!");
	    }
	    
	    Utente utente = utenteService.findByUsername(username);
	    Postazione postazione = postazioneService.findByCu(postazioneId);
	    
	    List<Prenotazione> prenotazioniUtente = prenotazioneRepo.findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
	    if (!prenotazioniUtente.isEmpty()) {
	        throw new Exception("Hai già una prenotazione per questa data!");
	    }

	    List<Prenotazione> prenotazioniEsistenti = prenotazioneRepo.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
	    if (!prenotazioniEsistenti.isEmpty()) {
	        throw new Exception("La postazione è già prenotata per quella data!");
	    }

	    Prenotazione prenotazione = new Prenotazione(dataPrenotazione, utente, postazione);
	    prenotazioneRepo.save(prenotazione);
	    return prenotazione;
	}
	
	public List<Prenotazione> getPrenotazioni(){
		return prenotazioneRepo.findAll();
	}
	
	public Prenotazione findByUUID(UUID id) {
		return prenotazioneRepo.findById(id).orElseThrow(() -> new RuntimeException());
	}
	
	public Prenotazione findByUUIDAndUpdate(UUID id, PrenotazionePayload prenotazionePayload) {
		Prenotazione found = this.findByUUID(id);
		
		found.setDataPrenotazione(prenotazionePayload.getDataPrenotazione());
		
		Postazione postazioneNuova = postazioneService.findByCu(prenotazionePayload.getPostazioneId());
		found.setPostazione(postazioneNuova);
		
		Utente utenteNuovo = utenteService.findByUsername(prenotazionePayload.getUsername());
		found.setUtente(utenteNuovo);

		return prenotazioneRepo.save(found);
	}
	
	public void findByUUIDAndDelete(UUID id) {
		Prenotazione found= this.findByUUID(id);
		prenotazioneRepo.delete(found);
	}
}
