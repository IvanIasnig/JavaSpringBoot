package ivaniasnig.esSpringI.allDao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.enums.TipoPostazione;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

	List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipoPost, String città);
	
}
