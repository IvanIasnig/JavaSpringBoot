package ivaniasnig.esSpringI.allDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esSpringI.classi.Utente;

@Repository
public interface EdificiRepository extends JpaRepository<Utente, String> {

}
