package ivaniasnig.esSpringI.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ivaniasnig.esSpringI.allDao.Services;
import ivaniasnig.esSpringI.classi.Edificio;
import ivaniasnig.esSpringI.classi.Postazione;
import ivaniasnig.esSpringI.classi.Prenotazione;
import ivaniasnig.esSpringI.classi.Utente;
import ivaniasnig.esSpringI.enums.TipoPostazione;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RunnerPrenotazioni implements CommandLineRunner{

	@Autowired
	private ApplicationContext ctx;
	
    @Autowired
    private Services services;
	
    @Override
    public void run(String... args) throws Exception{
        Utente utente = (Utente) ctx.getBean("utente");
        log.info(utente.toString());

        Utente utente2 = (Utente) ctx.getBean("utente2");
        log.info(utente2.toString());
        
        Edificio edificio = (Edificio) ctx.getBean("edificio");
        log.info(edificio.toString());
        
        Postazione postazione = (Postazione) ctx.getBean("postazione");
        postazione.setEdificio(edificio);
        log.info(postazione.toString());

        Prenotazione prenotazione = (Prenotazione) ctx.getBean("prenotazione");
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        log.info(prenotazione.toString());
        
        Prenotazione prenotazione2 = (Prenotazione) ctx.getBean("prenotazione2");
        prenotazione2.setUtente(utente2);
        prenotazione2.setPostazione(postazione);
        log.info(prenotazione2.toString());
        
        services.save(utente);
        services.save(utente2);
        services.save(edificio);
        services.save(postazione);
        services.save(prenotazione);
        services.save(prenotazione2);
        
        LocalDate date = LocalDate.now();
        
        boolean esistePrenotazioneOggi = services.postazioneLibera(postazione, date);
        if (esistePrenotazioneOggi) {
            log.info("Esiste già una prenotazione per la postazione: " + postazione.getCu() + " per oggi, scegli un altra data.");
        } else {
            log.info("Non esiste una prenotazione per la postazione: " + postazione.getCu() + " puoi prenotare! ");
        }
        
        LocalDate dateDomani = LocalDate.now().plusDays(1);
        
        boolean esistePrenotazioneDomani = services.postazioneLibera(postazione, dateDomani);
        if (!esistePrenotazioneDomani) {
            log.info("Esiste già una prenotazione per la postazione: " + postazione.getCu() + " per domani, scegli un'altra data ");
        } else {
            log.info("Non esiste una prenotazione per la postazione: " + postazione.getCu() + " puoi prenotare! ");
        }
     
        boolean utentePrenota = services.puoPrenotare(utente2, dateDomani);
        if (!utentePrenota) {
        	log.info("L'utente ha già una prenotazione per domani! Non può farne un'altra!");
        }else {
        	log.info("L'utente non ha nessuna prenotazione per domani, può prenotare tranquillamente");
        }
        
        services.findPostazione(TipoPostazione.PRIVATO,"Trieste");
    }
}
