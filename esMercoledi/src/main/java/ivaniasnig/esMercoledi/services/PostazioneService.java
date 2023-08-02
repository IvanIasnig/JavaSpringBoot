package ivaniasnig.esMercoledi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.enums.TipoPostazione;



@Service
public class PostazioneService {

	private List<Postazione> postazioni = new ArrayList<>();
	
	public Postazione save(Postazione postazione) {
		Random rand = new Random();
		postazione.setCu(rand.nextInt());
		this.postazioni.add(postazione);
		return postazione;
	}
	
	public List<Postazione> getPostazioni(){
		return this.postazioni;
	}
	
	public Optional<Postazione> findByCu(int cu){
		Postazione p = null;
		
		for (Postazione postazione : postazioni) {
			if(postazione.getCu() == cu)
				p = postazione;
		}
		return Optional.ofNullable(p);
	}
	
	public void findByCuAndDelete(int cu, Postazione postazione) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator();
		
		while(iterator.hasNext()) {
			Postazione currentPostazione =iterator.next();
			if(currentPostazione.getCu() == cu) {
				iterator.remove();
			}
		}
	}
	
	public Optional<Postazione> findByCuAndUpdate(int cu, Postazione postazione){
		Postazione found = null;
		
		for (Postazione currentPostazione : postazioni) {
			if(currentPostazione.getCu() == cu) {
				found = currentPostazione;
				found.setDescrizione(postazione.getDescrizione());
				found.setTipo(postazione.getTipo());
				found.setMaxPersone(postazione.getMaxPersone());
				found.setCitta(postazione.getCitta());
			}
		}
		return Optional.ofNullable(found);
	}
	
	public List<Postazione> findByTipoAndCitta (TipoPostazione tipoPostazione, String citta){
		List<Postazione> postazioniDue = postazioni.stream().filter((postazione) -> postazione.getTipo() == tipoPostazione && postazione.getCitta().equals(citta)).collect(Collectors.toList());
		
		if(!postazioniDue.isEmpty()) return postazioniDue;
		else return null;
		
	}
	
}
