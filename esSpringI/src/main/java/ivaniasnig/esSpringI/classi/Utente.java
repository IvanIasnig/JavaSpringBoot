package ivaniasnig.esSpringI.classi;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {
	@Id
	private String username;
	private String nomeCompleto;
	private String mail;
	
	@OneToMany(mappedBy = "utente")
	private Set<Prenotazione> prenotazioni;
	
	public Utente(String username, String nomeCompleto, String mail) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.mail = mail;
	}

}
