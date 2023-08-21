package ivaniasnig.es_lun_SB.utenti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UtenteLoginPayload {

	String email;
	String password;
}
