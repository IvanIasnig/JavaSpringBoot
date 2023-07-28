package ivaniasnig.esSpringI.allDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esSpringI.classi.Utente;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Services implements IDao {
	@Autowired
	private UtentiRepository utentiRepository;

	public void save(Utente utente) {
		utentiRepository.save(utente);
		log.info(utente.getNomeCompleto() + " salvato!");
	}

	public List<Utente> findAll() {
		return utentiRepository.findAll();
	}

	public Utente findById(String username) throws RuntimeException {
		return utentiRepository.findById(username).orElseThrow(() -> new RuntimeException(username));
	}

	public void findByIdAndUpdate(String username, Utente utente) throws RuntimeException {
		Utente found = this.findById(username); 

		found.setUsername(utente.getUsername());
		found.setNomeCompleto(utente.getNomeCompleto());
		found.setMail(utente.getMail());

		utentiRepository.save(found);
	}

	public void findByIdAndDelete(String username) throws RuntimeException {
		Utente found = this.findById(username);
		utentiRepository.delete(found);
	}

	public long count() {
		return utentiRepository.count();
	}
	
	

}

