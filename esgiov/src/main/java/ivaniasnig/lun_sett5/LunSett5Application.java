package ivaniasnig.lun_sett5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import Coperto.Ordine;
//import Coperto.Ordine;
//import Decorators.CozzeDecorator;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:application.properties")
public class LunSett5Application {

	public static void main(String[] args) {
		SpringApplication.run(LunSett5Application.class, args);
		
		configWithConfigAnnotation();

	}
	

	public static void configWithConfigAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LunSett5Application.class);

		// log.info((String) ctx.getBean("getMaglietta"));
		log.info(ctx.getBean("getMaglietta").toString());

		log.info(ctx.getBean("getPalaPerPizzaiolo").toString());
		
		log.info(ctx.getBean("coca").toString());
		
		log.info(ctx.getBean("fanta").toString());
		
		log.info(ctx.getBean("pizzam").toString());
		
		log.info(ctx.getBean("pizzacozze").toString());
		
		log.info(ctx.getBean("pizzasalameEcozze").toString());
		
		log.info(ctx.getBean("pizzaCozzeEananas").toString());
		
		log.info(ctx.getBean("ordine").toString());
		
		log.info(ctx.getBean("ordine").toString());
		log.info("Totale del primo ordine: " + ((Ordine) ctx.getBean("ordine")).totale());

        Ordine ordine2 = ctx.getBean(Ordine.class);
        ordine2.setNumeroOrdine(2);
        ordine2.setNumCoperti(4);

        log.info(ordine2.toString());
        log.info("Totale del secondo ordine: " + ordine2.totale());
        
        Ordine ordine3 = ctx.getBean(Ordine.class);
        ordine3.setNumeroOrdine(2);
        ordine3.setNumCoperti(8);
        List<Bevande> nuoveBevande = new ArrayList<>(ordine3.getBevande());
        nuoveBevande.add(ctx.getBean("coca", Bevande.class));
        ordine3.setBevande(nuoveBevande);
        List<Pizza> listaPizze = new ArrayList<>(ordine3.getPizze());
        listaPizze.add(ctx.getBean("pizzam",Pizza.class));
        listaPizze.add(ctx.getBean("pizzacozze",Pizza.class));
        listaPizze.add(ctx.getBean("pizzasalameEcozze",Pizza.class));
        listaPizze.add(ctx.getBean("pizzaCozzeEananas",Pizza.class));
        listaPizze.add(ctx.getBean("pizzaCozzeEananas",Pizza.class));
        listaPizze.add(ctx.getBean("pizzasalameEcozze",Pizza.class));
        listaPizze.add(ctx.getBean("pizzasalameEcozze",Pizza.class));
        ordine3.setPizze(listaPizze);
        
        log.info(ordine3.toString());
        log.info("Totale del terzo ordine: " + ordine3.totale());

		ctx.close();
	}
	
}
