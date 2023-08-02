package ivaniasnig.esMercoledi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.enums.TipoPostazione;
import ivaniasnig.esMercoledi.repository.PostazioniRepository;



@Service
public class PostazioneService {

	@Autowired
	private PostazioniRepository postazioniRepo;
	
	public Postazione save(Postazione postazione) {
		Random rand = new Random();
		postazione.setCu(rand.nextInt());
		return postazioniRepo.save(postazione);
	}
	
	public List<Postazione> getPostazioni(){
		return postazioniRepo.findAll();
	}
	
	public Postazione findByCu(int cu){
		return postazioniRepo.findById(cu).orElseThrow(() -> new RuntimeException());
	}
	
	public Postazione findByCuAndUpdate(int cu, Postazione postazione){
		Postazione found = this.findByCu(cu);
		
		found.setCitta(postazione.getCitta());
		found.setDescrizione(postazione.getDescrizione());
		found.setMaxPersone(postazione.getMaxPersone());
		found.setTipo(postazione.getTipo());
		
		return postazioniRepo.save(found);
	}
	
	public void findByCuAndDelete(int cu) {
		Postazione found = this.findByCu(cu);
		postazioniRepo.delete(found);
	}
	

	
	public List<Postazione> findByTipoAndCitta (TipoPostazione tipoPostazione, String citta){
		
		List<Postazione> postazioni = this.getPostazioni();
		
		List<Postazione> postazioniFiltrate = postazioni.stream()
				.filter((postazione) -> postazione.getTipo() == tipoPostazione && postazione.getCitta().equals(citta))
				.toList();
		
		if(!postazioniFiltrate.isEmpty()) return postazioniFiltrate;
		else return null;
		
	}
	
}
