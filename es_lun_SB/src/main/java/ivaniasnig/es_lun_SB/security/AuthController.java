package ivaniasnig.es_lun_SB.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ivaniasnig.es_lun_SB.exceptions.UnauthorizedException;
import ivaniasnig.es_lun_SB.utenti.Utente;
import ivaniasnig.es_lun_SB.utenti.UtenteLoginPayload;
import ivaniasnig.es_lun_SB.utenti.UtenteService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UtenteService utentiService;
	
	@Autowired
	JwtTools jwtTools;
	
	@Autowired
	PasswordEncoder bcrypt;
	
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUtente(@RequestBody Utente body) {
		body.setPassword(bcrypt.encode(body.getPassword()));
        Utente utente = new Utente(body.getNome(), body.getCognome(), body.getEmail(), body.getPassword(), body.getUsername());
        return utentiService.save(utente);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UtenteLoginPayload loginPayloadBody){
		//devo provare a modificare String
		
		Utente utente = utentiService.findByEmail(loginPayloadBody.getEmail());
		
		if(bcrypt.matches(loginPayloadBody.getPassword(), utente.getPassword())) {
			
			String token =jwtTools.createToken(utente);
			return new ResponseEntity<>(token, HttpStatus.OK); //200
		} else {
			throw new UnauthorizedException("Credenziali non valide"); //401
		}
	}
}
