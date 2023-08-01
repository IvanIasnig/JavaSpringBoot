package ivaniasnig.esMartedi.classi;

import java.util.Set;
import java.util.UUID;

import ivaniasnig.esMartedi.enums.TipoPostazione;
//import ivaniasnig.esSpringI.enums.TipoPostazione;
//import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Postazione {
//	@Id
//	@GeneratedValue
	private UUID cu;
	private String descrizione;
	//@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private int maxPersone;
	
	//@OneToOne
//	@JoinColumn(name = "edificio_id", referencedColumnName = "id")
	private Edificio edificio;
	
//	@OneToMany(mappedBy = "postazione")
	private Set<Prenotazione> prenotazioni;
	
	public Postazione(String descrizione, TipoPostazione tipo, int maxPersone) {
		this.descrizione = descrizione;
		this.tipo = tipo;
		this.maxPersone = maxPersone;
	}

}

