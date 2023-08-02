package ivaniasnig.esMartedi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;


import org.springframework.stereotype.Service;

import ivaniasnig.esMartedi.classi.Utente;

@Service
public class UtenteService {

	private List<Utente> utenti = new ArrayList<>();

	public Utente save(Utente utente) {
//		Random rndm = new Random();
//		Utente.setUsername(rndm.nextInt());
		this.utenti.add(utente);
		return utente;
	}

	public List<Utente> getUtenti() {
		return this.utenti;
	}

	public Optional<Utente> findByUsername(String username) {
		Utente u = null;

		for (Utente utente : utenti) {
			if (utente.getUsername().equals(username))
				u = utente;
		}

		return Optional.ofNullable(u);
		
	}
	
	

	public void findByUsernameAndDelete(String username) {
		ListIterator<Utente> iterator = this.utenti.listIterator();

		while (iterator.hasNext()) {
			Utente currentUtente = iterator.next();
			if (currentUtente.getUsername().equals(username)) {
				iterator.remove();
			}
		}
	}

	public Optional<Utente> findByUsernameAndUpdate(String username, Utente utente) {
		Utente found = null;

		for (Utente currentUtente : utenti) {
			if (currentUtente.getUsername().equals(username)) {
				found = currentUtente;
				found.setNomeCompleto(utente.getNomeCompleto());
				found.setMail(utente.getMail());
				found.setUsername(username);
			}
		}
		return Optional.ofNullable(found);

	}

}
