package ivaniasnig.es_lun_SB.dispositivi;

import java.util.UUID;

import ivaniasnig.es_lun_SB.utenti.Utente;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dispositivi {
	@Id
	@GeneratedValue
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	private DispositiviStato dispositiviStato;
	@Enumerated(EnumType.STRING)
	private DispositiviTipo dispositiviTipo;
	
	@ManyToOne
	private Utente utente;
	
}
