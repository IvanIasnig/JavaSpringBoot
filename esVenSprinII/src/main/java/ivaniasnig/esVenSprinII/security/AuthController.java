package ivaniasnig.esVenSprinII.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ivaniasnig.esVenSprinII.exceptions.UnauthorizedException;
import ivaniasnig.esVenSprinII.utenti.Utente;
import ivaniasnig.esVenSprinII.utenti.UtenteLoginPayload;
import ivaniasnig.esVenSprinII.utenti.UtenteService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UtenteService utentiService;
	
	@Autowired
	JwtTools jwtTools;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUtente(@RequestBody Utente body) {
        Utente utente = new Utente(body.getNome(), body.getCognome(), body.getEmail(), body.getPassword(), body.getUsername());
        return utentiService.save(utente);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UtenteLoginPayload loginPayloadBody){
		//devo provare a modificare String
		
		Utente utente = utentiService.findByEmail(loginPayloadBody.getEmail());
		
		if(loginPayloadBody.getPassword().equals(utente.getPassword())) {
			
			String token =jwtTools.createToken(utente);
			return new ResponseEntity<>(token, HttpStatus.OK); //200
		} else {
			throw new UnauthorizedException("Credenziali non valide"); //401
		}
	}
}
