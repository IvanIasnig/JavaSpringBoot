package ivaniasnig.esSpringI.classi;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Prenotazione {
	
	@Id
	@GeneratedValue
	private UUID id;

	private LocalDate dataPrenotazione;
	
	@ManyToOne
	@JoinColumn(name = "utente_username")
	private Utente utente;
	
	@ManyToOne
	@JoinColumn(name = "postazione_cu")
	private Postazione postazione;
	
	public Prenotazione(LocalDate dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
}
