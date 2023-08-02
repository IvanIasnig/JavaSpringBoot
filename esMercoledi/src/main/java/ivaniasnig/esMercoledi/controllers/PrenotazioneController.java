package ivaniasnig.esMercoledi.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	// 1. - POST http://localhost:3001/prenotazione (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Prenotazione savePrenotazione(@RequestBody PrenotazionePayload body) throws Exception {
		LocalDate dataPrenotazione = body.getDataPrenotazione();
		int  postazioneId = body.getPostazioneId();
		String username = body.getUsername();
		
		Prenotazione prenotazioneCreata = prenotazioneService.save(dataPrenotazione, postazioneId, username);
		return prenotazioneCreata;
	}
	
	// 2. - GET http://localhost:3001/prenotazione (+ opzionalmente query params)
	@GetMapping("")
	public List<Prenotazione> getPrenotazioni(){
		return prenotazioneService.getPrenotazioni();
	}
	
	// 3. - GET http://localhost:3001/prenotazione/{id}
	@GetMapping("/{id}")
	public Prenotazione findByUUUID (@PathVariable UUID id) {
		return prenotazioneService.findByUUID(id);
	}
	
	// 4. - PUT http://localhost:3001/prenotazione/{id} (+ req.body)
	@PutMapping("/{id}")
	public Prenotazione findPrenotazioneAndUpdate (@PathVariable UUID id, @RequestBody PrenotazionePayload body) {
		return prenotazioneService.findByUUIDAndUpdate(id, body);
	}
	
	// 5. - DELETE http://localhost:3001/prenotazione/{id}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findPrenotazioneAndDelete (@PathVariable UUID id) {
		prenotazioneService.findByUUIDAndDelete(id);
	}
	
	
}
