package ivaniasnig.es_lun_SB.dispositivi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


import org.springframework.http.HttpStatus;

@RequestMapping("/utenti/dispositivi")
@RestController
public class DispositiviController {

	@Autowired
	private DispositiviService dispositiviService;
	
	// POST 
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Dispositivi saveDispositivo(@RequestBody Dispositivi body) {
		UUID idUtente = body.getUtente().getId(); //prova fix 403
		Dispositivi dispositiviCreato = dispositiviService.save(body, idUtente);
		return dispositiviCreato;
	} 
	
	// GET 
	@GetMapping("")
	public Page<Dispositivi> getDispositivi(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "id") String sortBy) {
		return dispositiviService.find(page, size, sortBy);
	}
	
	// GET (by Id)
	@GetMapping("/{id}")
	public Dispositivi findById(@PathVariable UUID id) {
		return dispositiviService.findById(id);
	}
	
	// PUT 
	@PutMapping("/{id}")
	public Dispositivi findAndUpdate(@PathVariable UUID id, @RequestBody Dispositivi body) {
		return dispositiviService.findByIdAndUpdate(id,body);

	}
	
	// DELETE
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findAndDelete(@PathVariable UUID id) {
		dispositiviService.findByIdAndDelete(id);
	}
}
