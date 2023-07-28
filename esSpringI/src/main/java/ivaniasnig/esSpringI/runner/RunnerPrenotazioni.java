package ivaniasnig.esSpringI.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ivaniasnig.esSpringI.allDao.Services;
import ivaniasnig.esSpringI.classi.Edificio;
import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.classi.Utente;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RunnerPrenotazioni implements CommandLineRunner{

	@Autowired
	private ApplicationContext ctx;
	
    @Autowired
    private Services utenteService;
	
	@Override
	public void run(String... args) throws Exception{
        Utente utente = (Utente) ctx.getBean("utente");
        utenteService.save(utente);
        log.info(utente.toString());

        Utente utente2 = (Utente) ctx.getBean("utente2");
        utenteService.save(utente2);
        log.info(utente2.toString());
	    
	    Prenotazione prenotazione = (Prenotazione) ctx.getBean("prenotazione");
	    prenotazione.setUtente(utente);
	    log.info(prenotazione.toString());
	    
	    Prenotazione prenotazione2 = (Prenotazione) ctx.getBean("prenotazione2");
	    prenotazione2.setUtente(utente2);
	    log.info(prenotazione2.toString());
	    
	    Edificio edificio = (Edificio) ctx.getBean("edificio");
	    log.info(edificio.toString());
	    
	    Postazione postazione = (Postazione) ctx.getBean("postazione");
	    postazione.setEdificio(edificio);
	    log.info(postazione.toString());
	    
	}

}
