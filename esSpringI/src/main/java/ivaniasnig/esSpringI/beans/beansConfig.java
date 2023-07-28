package ivaniasnig.esSpringI.beans;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ivaniasnig.esSpringI.classi.Edificio;
import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.classi.Utente;
import ivaniasnig.esSpringI.enums.TipoPostazione;

@Configuration
public class beansConfig {
	
	@Bean
	Utente utente() {
		return new Utente("JJGiacominoIlPazzo","Giacomo Rossi","giacominopastafrolla@gmail.com");
	}
	
	@Bean
	Utente utente2() {
		return new Utente("Pierpa08gg","Pierpaolo Senzacognome","giocotuttoilgiornoaLoL@gmail.com");
	}

	@Bean
	Utente utente3() {
		return new Utente("Mario","Rossi","fagiano@gmail.com");
	}
	
	@Bean
	Prenotazione prenotazione() {
		return new Prenotazione(LocalDate.now());
	}
	
	@Bean
	Prenotazione prenotazione2() {
		return new Prenotazione(LocalDate.now().plusDays(2));
	}
	
	@Bean
	Edificio edificio() {
		return new Edificio("Ivan", "via Giulia", "Trieste");
	}
	
	@Bean
	Postazione postazione() {
		return new Postazione("Una bella postazione", TipoPostazione.PRIVATO, 20);
	}

}
