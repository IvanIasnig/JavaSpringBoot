package ivaniasnig.esSpringI.allDao;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.classi.Utente;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

	boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
	
	boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

}
