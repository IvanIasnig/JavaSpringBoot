package ivaniasnig.esMercoledi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.classi.Prenotazione;
import ivaniasnig.esMercoledi.classi.Utente;


@Service
public class PrenotazioneService {
	List<Prenotazione> listaPrenotazioni = new ArrayList<>();
	
	@Autowired
	PostazioneService postazioneService;
	
	@Autowired
	UtenteService utenteService;
	
	public Prenotazione save(LocalDate dataPrenotazione, int postazioneId, String username) throws Exception {
		Random rand = new Random();
		Utente utente = utenteService.findByUsername(username).orElseThrow(() -> new Exception(" Utente non trovato :D "));
		Postazione postazione = postazioneService.findByCu(postazioneId).orElseThrow(() -> new Exception(" Postazione non trovata D:"));
		
		Prenotazione prenotazione = new Prenotazione(rand.nextInt(), dataPrenotazione, utente, postazione);
		this.listaPrenotazioni.add(prenotazione);
		return prenotazione;
	}
	
	
}
