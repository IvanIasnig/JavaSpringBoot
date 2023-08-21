package ivaniasnig.es_lun_SB.utenti;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/utenti")
@RestController
public class UtenteController {
	
	@Autowired
	private UtenteService utentiService;
	
//	// POST 
//	@PostMapping("")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Utente saveUtente(@RequestBody Utente body) {
//		Utente utenteCreato = utentiService.save(body);
//		return utenteCreato;
//	}
	
	// GET 
	@GetMapping("")
	public Page<Utente> getUtenti(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return utentiService.find(page, size, sortBy);
	}
	
	// GET (by Id)
	@GetMapping("/{id}")
	public Utente findByUsername(@PathVariable UUID id) { //devo cambiare il nome del metodo
		return utentiService.findById(id);
	}
	
	// PUT 
	@PutMapping("/{id}")
	public Utente findAndUpdate(@PathVariable UUID id, @RequestBody Utente body) {
		return utentiService.findByIdAndUpdate(id,body);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable UUID id) {
		utentiService.findByIdAndDelete(id);
	}
	
}
