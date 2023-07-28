package ivaniasnig.esSpringI.classi;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Edificio {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String indirizzo;
	private String citta;
	
	@OneToOne(mappedBy = "edificio")
	private Postazione postazione;
	
	public Edificio(String nome, String indirizzo, String citta) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.citta = citta;
	}
	
	
}
