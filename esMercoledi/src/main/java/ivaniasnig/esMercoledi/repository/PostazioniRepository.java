package ivaniasnig.esMercoledi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ivaniasnig.esMercoledi.classi.Postazione;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, Integer> {

}
