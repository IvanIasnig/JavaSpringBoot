package ivaniasnig.esMercoledi.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ivaniasnig.esMercoledi.classi.Prenotazione;
import ivaniasnig.esMercoledi.classi.PrenotazionePayload;
import ivaniasnig.esMercoledi.services.PrenotazioneService;



@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	// 1. - POST http://localhost:3001/users (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione savePrenotazione(@RequestBody PrenotazionePayload body) throws Exception {
		LocalDate dataPrenotazione = body.getDataPrenotazione();
		int  postazioneId = body.getPostazioneId();
		String username = body.getUsername();
		
		Prenotazione prenotazioneCreata = prenotazioneService.save(dataPrenotazione, postazioneId, username);
		return prenotazioneCreata;
	}
	
}
