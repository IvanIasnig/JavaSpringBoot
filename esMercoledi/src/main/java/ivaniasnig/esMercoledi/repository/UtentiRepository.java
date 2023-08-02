package ivaniasnig.esMercoledi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esMercoledi.classi.Utente;

@Repository
public interface UtentiRepository extends JpaRepository<Utente, String> {
	
}
