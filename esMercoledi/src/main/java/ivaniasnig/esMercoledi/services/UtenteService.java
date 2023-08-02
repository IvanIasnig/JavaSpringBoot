package ivaniasnig.esMercoledi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public Page<Utente> getUtenti(int page, int size, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
		return utentiRepo.findAll(pageable);
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
