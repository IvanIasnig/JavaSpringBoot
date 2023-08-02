package ivaniasnig.esMartedi.classi;

import java.util.Set;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class Utente {

	private String username;
	private String nomeCompleto;
	private String mail;

	//private Set<Prenotazione> prenotazioni;
	
	public Utente(String username, String nomeCompleto, String mail) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.mail = mail;
	}

}

