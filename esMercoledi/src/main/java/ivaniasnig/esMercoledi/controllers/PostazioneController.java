package ivaniasnig.esMercoledi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.enums.TipoPostazione;
import ivaniasnig.esMercoledi.services.PostazioneService;



@RestController
@RequestMapping("/postazione")
public class PostazioneController {
	
	@Autowired
	PostazioneService postazioneService;
	
	// 1. - POST http://localhost:3001/postazione (+ req.body)
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePostazione(@RequestBody Postazione body) {
		Postazione postazioneCreata = postazioneService.save(body);
		return postazioneCreata;
	}
	
	
	// 2. - GET http://localhost:3001/postazione (+ opzionalmente query params)
	@GetMapping("")
	public List<Postazione> getPostazione(){
		return postazioneService.getPostazioni();
	}
	
	// 3. - GET http://localhost:3001/postazione/{id}
	@GetMapping("/{cu}")
	public Postazione findByCu(@PathVariable int cu) throws Exception {
		return postazioneService.findByCu(cu);
	}
	
	;
	@PutMapping("/{cu}")
	public Postazione findPostazioneAndUpdate(@PathVariable int cu, @RequestBody Postazione body) {
		return postazioneService.findByCuAndUpdate(cu, body);
	}
	
	// 5. - DELETE http://localhost:3001/postazione/{id}
	@DeleteMapping("/{cu}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findPostazioneAndDelete(@PathVariable int cu) {
		postazioneService.findByCuAndDelete(cu);
	}

    @GetMapping("/booking-rules")
    public ResponseEntity<String> getBookingRules(@RequestParam("lang") String lang) {
        String rules;

        switch (lang) {
            case "it":
                rules = "Le regole per la prenotazione sono: rispondere male al receptionist";
                break;
            case "en":
                rules = "The rules for booking are: rispons mals tu de resepscionist";
                break;
            default:
                return new ResponseEntity<>("Unsupported language", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(rules, HttpStatus.OK);
    }
    
    @GetMapping("/search")
    public List<Postazione> getPostazioniByCittaAndTipo(@RequestParam TipoPostazione tipoPostazione, @RequestParam String citta){
    	return postazioneService.findByTipoAndCitta(tipoPostazione, citta);
    }
    
    
}



