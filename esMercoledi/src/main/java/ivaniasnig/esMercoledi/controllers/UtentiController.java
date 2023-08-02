package ivaniasnig.esMercoledi.controllers;

import java.util.List;

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

import ivaniasnig.esMercoledi.classi.Utente;
import ivaniasnig.esMercoledi.services.UtenteService;

@RestController
@RequestMapping("/utente")
public class UtentiController {
	
	@Autowired
	UtenteService utenteService;
	
	// 1. - POST http://localhost:3001/users (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUtente(@RequestBody Utente body) {
		Utente utenteCreato = utenteService.save(body);
		return utenteCreato;
	}
	
	// 2. - GET http://localhost:3001/users (+ opzionalmente query params)
	@GetMapping("")
	public List<Utente> getUtenti() {
		return utenteService.getUtenti();
	}
	
	// 3. - GET http://localhost:3001/users/{id}
	@GetMapping("/{username}")
	public Utente findByUsername(@PathVariable String username) throws Exception {
		return utenteService.findByUsername(username).orElseThrow(() -> new Exception("NON TROVATO"));
	}
	
	// 4. - PUT http://localhost:3001/users/{id} (+ req.body)
	@PutMapping("/{username}")
	public Utente findAndUpdate(@PathVariable String username, @RequestBody Utente body) throws Exception {
		return utenteService.findByUsernameAndUpdate(username,body).orElseThrow(() -> new Exception("NON TROVATO"));
	}
	
	// 5. - DELETE http://localhost:3001/users/{id}
	@DeleteMapping("/{username}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable String username) {
		utenteService.findByUsernameAndDelete(username);
	}
	
}
