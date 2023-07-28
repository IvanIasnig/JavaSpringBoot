package ivaniasnig.esSpringI.allDao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esSpringI.classi.Prenotazione;

@Repository
public interface PostazioniRepository extends JpaRepository<Prenotazione, UUID> {

}
