package ivaniasnig.esSpringI.allDao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esSpringI.classi.Edificio;
import ivaniasnig.esSpringI.classi.Utente;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {

}
