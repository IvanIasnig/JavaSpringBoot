package ivaniasnig.esMercoledi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ivaniasnig.esMercoledi.classi.Postazione;
import ivaniasnig.esMercoledi.classi.Prenotazione;
import ivaniasnig.esMercoledi.classi.Utente;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
	List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);
	List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

}
