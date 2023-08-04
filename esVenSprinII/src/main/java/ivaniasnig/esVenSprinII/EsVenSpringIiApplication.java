package ivaniasnig.esVenSprinII;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ivaniasnig.esVenSprinII.utenti.Utente;
import ivaniasnig.esVenSprinII.utenti.UtenteService;

@SpringBootApplication
public class EsVenSpringIiApplication {
	
//	@Autowired
//	UtenteService utentiService;

	public static void main(String[] args) {
		SpringApplication.run(EsVenSpringIiApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner initData() {
//		return args -> {
//			Utente user = new Utente("Mario", "Rossi", "ciao@gmail.com", "abc123");
//			utentiService.save(user);
//		};
//	}
}

