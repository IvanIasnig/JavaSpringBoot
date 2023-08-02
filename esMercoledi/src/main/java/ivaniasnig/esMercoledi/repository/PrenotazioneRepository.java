package ivaniasnig.esMercoledi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ivaniasnig.esMercoledi.classi.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

}
