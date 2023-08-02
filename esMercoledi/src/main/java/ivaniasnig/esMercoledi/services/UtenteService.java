package ivaniasnig.esMercoledi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esMercoledi.classi.Utente;
import ivaniasnig.esMercoledi.repository.UtentiRepository;


@Service
public class UtenteService {

	@Autowired
	private UtentiRepository utentiRepo;
	
// private List<Utente> utenti = new ArrayList<>();

	public Utente save(Utente utente) {
		return utentiRepo.save(utente);
	}

	public List<Utente> getUtenti() {
		return utentiRepo.findAll();
	}

	public Utente findByUsername(String username) {
		return utentiRepo.findById(username).orElseThrow(() -> new RuntimeException());
	}
	
	public Utente findByUsernameAndUpdate(String username, Utente utente) {
		Utente found = this.findByUsername(username);

		found.setMail(utente.getMail());
		found.setNomeCompleto(utente.getNomeCompleto());
		found.setUsername(username);
		return utentiRepo.save(found);

	}
	
	public void findByUsernameAndDelete(String username) {

		Utente found = this.findByUsername(username);
		utentiRepo.delete(found);
	}


}
