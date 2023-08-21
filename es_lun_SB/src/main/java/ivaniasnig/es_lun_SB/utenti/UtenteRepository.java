package ivaniasnig.es_lun_SB.utenti;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository  extends JpaRepository<Utente, UUID>{
	Optional<Utente> findByEmail(String email);
}
